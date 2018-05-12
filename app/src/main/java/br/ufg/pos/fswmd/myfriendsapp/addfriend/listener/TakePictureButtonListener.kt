package br.ufg.pos.fswmd.myfriendsapp.addfriend.listener

import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.FragmentActivity
import android.support.v4.content.FileProvider
import android.view.View
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class TakePictureButtonListener(
        private val context: FragmentActivity
    ): View.OnClickListener {

    companion object {
        const val REQUEST_PICTURE_CODE: Int = 1
        var file: Uri? = null
    }

    override fun onClick(v: View?) {
        var takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (getOutputMediaFile() != null) {
            file = FileProvider.getUriForFile(context, "${context.packageName}.provider", getOutputMediaFile()!!)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, file)

            context.startActivityForResult(takePictureIntent, REQUEST_PICTURE_CODE)
        }

    }

    private fun getOutputMediaFile(): File? {
        var mediaStorageDir = File(context.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), "CameraDemo")

        if (mediaStorageDir.exists().not()) {
            if (mediaStorageDir.mkdirs().not()) {
                return null
            }
        }

        var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        return File("${mediaStorageDir}${File.separator}IMG_${timestamp}_.mySecret")
    }
}