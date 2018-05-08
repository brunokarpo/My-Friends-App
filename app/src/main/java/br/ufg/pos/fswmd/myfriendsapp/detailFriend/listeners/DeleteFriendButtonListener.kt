package br.ufg.pos.fswmd.myfriendsapp.detailFriend.listeners

import android.view.View
import br.ufg.pos.fswmd.myfriendsapp.detailFriend.activity.DetailFriendPresenter
import br.ufg.pos.fswmd.myfriendsapp.model.Friend

class DeleteFriendButtonListener(
        private val presenter: DetailFriendPresenter,
        private val friend: Friend
    ): View.OnClickListener {

    override fun onClick(v: View?) {
        presenter.deleteFriend(friend)
    }

}