package br.ufg.pos.fswmd.myfriendsapp.repository.migrations

import android.database.sqlite.SQLiteDatabase
import br.ufg.pos.fswmd.myfriendsapp.repository.QUERY_ADD_PHOTO_URL_COLUMN_TABLE_FRIEND

class Version3(
        private val db: SQLiteDatabase
    ) : AbstractMigrateVersionChain() {

    override fun getNext(): MigrateVersion? {
        return null
    }

    override fun getVersion(): Int {
        return 3
    }

    override fun exec() {
        db.execSQL(QUERY_ADD_PHOTO_URL_COLUMN_TABLE_FRIEND)
    }

}
