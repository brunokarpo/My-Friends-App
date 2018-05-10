package br.ufg.pos.fswmd.myfriendsapp.addfriend.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import br.ufg.pos.fswmd.myfriendsapp.R
import br.ufg.pos.fswmd.myfriendsapp.addfriend.listener.SaveButtonListener
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendDatabaseHandler
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendRepository
import kotlinx.android.synthetic.main.activity_main.*

class AddFriendActivity : AppCompatActivity(), AddFriendView {

    private var presenter: AddFriendPresenter? = null
    private var friendRepository: FriendRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        friendRepository = FriendDatabaseHandler(this)

        presenter = AddFriendPresenterImpl(this, friendRepository!!)

        save_button_id.setOnClickListener(
                SaveButtonListener(presenter!!, name_edit_id, nickname_edit_id, description_edit_id)
        )

        // enabling button back on action bar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setTitle(R.string.new_friend_title)
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
