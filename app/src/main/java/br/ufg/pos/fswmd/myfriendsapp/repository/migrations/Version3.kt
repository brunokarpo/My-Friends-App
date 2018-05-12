package br.ufg.pos.fswmd.myfriendsapp.repository.migrations

import android.database.sqlite.SQLiteDatabase
import br.ufg.pos.fswmd.myfriendsapp.repository.FRIEND_TABLE_NAME
import br.ufg.pos.fswmd.myfriendsapp.repository.KEY_PHOTO_URL

class Version3(
        private val db: SQLiteDatabase
    ) : AbstractMigrateVersionChain(3) {

    private val QUERY_ADD_PHOTO_URL_COLUMN_TABLE_FRIEND = "ALTER TABLE $FRIEND_TABLE_NAME ADD COLUMN $KEY_PHOTO_URL TEXT"

    override fun getNext(): MigrateVersion? {
        return null
    }

    override fun exec() {
        db.execSQL(QUERY_ADD_PHOTO_URL_COLUMN_TABLE_FRIEND)
    }

}
