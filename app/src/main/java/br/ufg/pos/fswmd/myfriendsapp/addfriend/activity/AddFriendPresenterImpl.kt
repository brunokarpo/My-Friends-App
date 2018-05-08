package br.ufg.pos.fswmd.myfriendsapp.addfriend.activity

import android.text.TextUtils
import br.ufg.pos.fswmd.myfriendsapp.model.Friend
import br.ufg.pos.fswmd.myfriendsapp.repository.FriendRepository

class AddFriendPresenterImpl(
        private val view: AddFriendView,
        private val repository: FriendRepository
    ): AddFriendPresenter {


    override fun saveFriend(name: String?, nickname: String?, description: String?) {
        if (TextUtils.isEmpty(name)) {
            view.showMessageNameRequired()
            return
        }

        var friend = Friend(name, nickname, description)

        repository.save(friend)

        view.showMessageFriendSaveSuccessfully()
        view.clearFields()
        view.goToListFriendsActivity()
    }

}