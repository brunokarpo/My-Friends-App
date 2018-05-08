package br.ufg.pos.fswmd.myfriendsapp.repository

import android.util.Log
import br.ufg.pos.fswmd.myfriendsapp.model.Friend

class FriendDatabaseHandler: FriendRepository {

    override fun save(friend: Friend) {
        // TODO: implementar banco de dados aqui...
        Log.d("Database handler", "Friend saved...")
    }
}