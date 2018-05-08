package br.ufg.pos.fswmd.myfriendsapp.listfriends.listeners

import android.content.Context
import android.content.Intent
import android.view.View
import br.ufg.pos.fswmd.myfriendsapp.detailFriend.activity.DetailFriendActivity
import br.ufg.pos.fswmd.myfriendsapp.model.Friend
import br.ufg.pos.fswmd.myfriendsapp.repository.KEY_ID

class RetrieveFriendListener(
        private val context: Context,
        private val friend: Friend
    ): View.OnClickListener {

    override fun onClick(v: View?) {
        var intent = Intent(context, DetailFriendActivity::class.java)

        intent.putExtra(KEY_ID, friend.id)

        context.startActivity(intent)
    }

}