package br.ufg.pos.fswmd.myfriendsapp.listfriends.activity

import br.ufg.pos.fswmd.myfriendsapp.model.Friend
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendRepository

class ListFriendsPresenterImpl(
        private val view: ListFriendsView,
        private val repository: FriendRepository
    ) : ListFriendsPresenter {

    override fun loadFriends() {
        val friendsArray: ArrayList<Friend> = repository.getAll()

        if (friendsArray.isEmpty()) {
            view.goToAddNewFriendActivity()
            return
        }

        view.fillFriendsList(friendsArray)
    }

}
