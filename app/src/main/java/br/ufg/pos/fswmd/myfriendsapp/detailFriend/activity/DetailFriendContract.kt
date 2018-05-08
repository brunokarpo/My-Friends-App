package br.ufg.pos.fswmd.myfriendsapp.detailFriend.activity

import br.ufg.pos.fswmd.myfriendsapp.model.Friend

interface DetailFriendView {

    fun fillFriend(friend: Friend)

    fun finalizeActivity()

    fun showMessageErrorRetrieveFriend()

    fun showMessageFriendDeletedSuccessfully()

}

interface DetailFriendPresenter {

    fun retrieveFriendById(id: Long)

    fun deleteFriend(friend: Friend)

}