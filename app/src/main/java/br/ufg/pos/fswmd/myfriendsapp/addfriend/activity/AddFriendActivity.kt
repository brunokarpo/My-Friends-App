package br.ufg.pos.fswmd.myfriendsapp.addfriend.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import br.ufg.pos.fswmd.myfriendsapp.R
import br.ufg.pos.fswmd.myfriendsapp.addfriend.listener.SaveButtonListener
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendDatabaseHandler
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendRepository
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class AddFriendActivity : AppCompatActivity(), AddFriendView {

    private val REQUEST_PERMISSION_CODE: Int = 0
    private val REQUEST_PICTURE_CODE: Int = 1

    private var presenter: AddFriendPresenter? = null
    private var friendRepository: FriendRepository? = null

    private var file: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        friendRepository = FriendDatabaseHandler(this)

        presenter = AddFriendPresenterImpl(this, friendRepository!!)

        save_button_id.setOnClickListener(
                SaveButtonListener(presenter!!, name_edit_id, nickname_edit_id, description_edit_id)
        )

        // requesting permission to access camera and write in directory
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            take_picture_button_id.isEnabled = false
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_PERMISSION_CODE)
        }

        if (take_picture_button_id.isEnabled) {
            take_picture_button_id.setOnClickListener {
                var takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (getOutputMediaFile() != null) {
                    file = FileProvider.getUriForFile(this, "${this.packageName}.provider", getOutputMediaFile()!!)
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, file)

                    startActivityForResult(takePictureIntent, REQUEST_PICTURE_CODE)
                }
            }
        }

        // enabling button back on action bar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setTitle(R.string.new_friend_title)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode.equals(REQUEST_PICTURE_CODE)
                        .and(resultCode.equals(Activity.RESULT_OK))) {
            take_picture_button_id.setImageURI(file)
        }

    }

    private fun getOutputMediaFile(): File? {
        var mediaStorageDir = File(getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), "CameraDemo")

        if (mediaStorageDir.exists().not()) {
            if (mediaStorageDir.mkdirs().not()) {
                return null
            }
        }

        var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        return File("${mediaStorageDir}${File.separator}IMG_${timestamp}_.mySecret")
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode.equals(REQUEST_PERMISSION_CODE)) {
            if (grantResults.isNotEmpty()
                            .and(grantResults[0].equals(PackageManager.PERMISSION_GRANTED))) {
                take_picture_button_id.isEnabled = true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else ->  {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun showMessageNameRequired() {
        Toast.makeText(this, R.string.name_is_required, Toast.LENGTH_LONG).show()
    }

    override fun showMessageFriendSaveSuccessfully() {
        Toast.makeText(this, R.string.friend_save_successfully, Toast.LENGTH_LONG).show()
    }

    override fun clearFields() {
        name_edit_id.text.clear()
        nickname_edit_id.text.clear()
        description_edit_id.text.clear()
    }

    override fun finishActivity() {
        finish()
    }
}
