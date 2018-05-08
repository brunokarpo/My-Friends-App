package br.ufg.pos.fswmd.myfriendsapp.listfriends.activity

import br.ufg.pos.fswmd.myfriendsapp.model.Friend

interface ListFriendsView {

    fun fillFriendsList(friendsArray: ArrayList<Friend>)

}

interface ListFriendsPresenter {

    fun loadFriends()

}