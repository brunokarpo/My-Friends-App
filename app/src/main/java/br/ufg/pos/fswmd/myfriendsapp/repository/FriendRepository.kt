package br.ufg.pos.fswmd.myfriendsapp.repository

import br.ufg.pos.fswmd.myfriendsapp.model.Friend

interface FriendRepository {

    fun save(friend: Friend)

    fun getAll(): ArrayList<Friend>

    fun findById(id: Int): Friend?

    fun delete(friend: Friend)

}