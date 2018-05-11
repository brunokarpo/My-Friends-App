package br.ufg.pos.fswmd.myfriendsapp.detailFriend.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.ufg.pos.fswmd.myfriendsapp.R
import br.ufg.pos.fswmd.myfriendsapp.detailFriend.listeners.DeleteFriendButtonListener
import br.ufg.pos.fswmd.myfriendsapp.model.Friend
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendDatabaseHandler
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendRepository
import br.ufg.pos.fswmd.myfriendsapp.repository.KEY_ID
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_friend.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailFriendActivity : AppCompatActivity(), DetailFriendView {

    private val repository: FriendRepository = FriendDatabaseHandler(this)

    private var presenter: DetailFriendPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_friend)

        presenter = DetailFriendPresenterImpl(this, repository)

        var data = intent.extras
        var friendId = data.getInt(KEY_ID)

        presenter!!.retrieveFriendById(friendId)

        // enabling button back on action bar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setTitle(R.string.detail_friend_title)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun fillFriend(friend: Friend) {
        detail_friend_name_text_id.text = friend.name
        detail_friend_nickname_text_id.text = friend.nickname
        detail_friend_description_text_id.text = friend.description

        if (friend.photoUrl.isNullOrBlank().not()) {
            Picasso.get()
                    .load(friend.photoUrl)
                    .into(friend_photo_image_view_id)
        }

        detail_friend_delete_button_id.setOnClickListener(
                DeleteFriendButtonListener(presenter!!, friend)
        )
    }

    override fun finalizeActivity() {
        finish()
    }

    override fun showMessageErrorRetrieveFriend() {
        Toast.makeText(applicationContext, R.string.error_retrieve_friend_detail, Toast.LENGTH_LONG).show()
    }

    override fun showMessageFriendDeletedSuccessfully() {
        Toast.makeText(applicationContext, R.string.friend_deleted_successfully, Toast.LENGTH_LONG).show()
    }
}
