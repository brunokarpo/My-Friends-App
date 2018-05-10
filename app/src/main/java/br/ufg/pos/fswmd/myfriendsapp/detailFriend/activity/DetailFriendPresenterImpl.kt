package br.ufg.pos.fswmd.myfriendsapp.detailFriend.activity

import br.ufg.pos.fswmd.myfriendsapp.model.Friend
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendRepository

class DetailFriendPresenterImpl(
        private val view: DetailFriendView,
        private val repository: FriendRepository
    ): DetailFriendPresenter {

    override fun retrieveFriendById(id: Int) {
        var friend = repository.findById(id)

        if (friend == null) {
            view.showMessageErrorRetrieveFriend()
            view.finalizeActivity()
            return
        }

        view.fillFriend(friend!!)
    }

    override fun deleteFriend(friend: Friend) {
        repository.delete(friend)

        view.showMessageFriendDeletedSuccessfully()
        view.finalizeActivity()
    }
}