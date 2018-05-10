package br.ufg.pos.fswmd.myfriendsapp.listfriends.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import br.ufg.pos.fswmd.myfriendsapp.R
import br.ufg.pos.fswmd.myfriendsapp.addfriend.activity.AddFriendActivity
import br.ufg.pos.fswmd.myfriendsapp.listfriends.data.FriendAdapter
import br.ufg.pos.fswmd.myfriendsapp.model.Friend
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendDatabaseHandler
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendRepository
import kotlinx.android.synthetic.main.activity_list_friends.*

class ListFriendsActivity : AppCompatActivity(), ListFriendsView {

    private var presenter: ListFriendsPresenter? = null
    private val repository: FriendRepository = FriendDatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_friends)

        presenter = ListFriendsPresenterImpl(this, repository)
    }

    override fun onResume() {
        super.onResume()
        presenter!!.loadFriends()
    }

    override fun fillFriendsList(friendsArray: ArrayList<Friend>) {
        var layoutManager = LinearLayoutManager(this)
        var adapter = FriendAdapter(friendsArray, this)

        list_friends_recycler_view_id.layoutManager = layoutManager
        list_friends_recycler_view_id.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    override fun goToAddNewFriendActivity() {
        var intent = Intent(this, AddFriendActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list_friends, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            R.id.add_new_friend_menu_button_id -> {
                goToAddNewFriendActivity()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
