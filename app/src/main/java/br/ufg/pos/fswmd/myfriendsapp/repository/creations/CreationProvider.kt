package br.ufg.pos.fswmd.myfriendsapp.repository.creations

import android.database.sqlite.SQLiteDatabase

class CreationProvider {

    companion object {
        fun getCreator(db: SQLiteDatabase): CreateVersion {
            return Version1(db)
        }
    }
}