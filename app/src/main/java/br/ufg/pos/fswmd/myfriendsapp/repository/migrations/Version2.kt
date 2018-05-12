package br.ufg.pos.fswmd.myfriendsapp.repository.migrations

import android.database.sqlite.SQLiteDatabase
import br.ufg.pos.fswmd.myfriendsapp.repository.QUERY_CREATE_FRIEND_TABLE_NEW
import br.ufg.pos.fswmd.myfriendsapp.repository.QUERY_DROP_FRIEND_TABLE
import br.ufg.pos.fswmd.myfriendsapp.repository.QUERY_RENAME_TABLE_FRIEND
import br.ufg.pos.fswmd.myfriendsapp.repository.QUERY_TRANSFER_DATA_BETWEEN_TABLES_FRIEND

class Version2(
        private val db: SQLiteDatabase
    ): AbstractMigrateVersionChain() {

    override fun getNext(): MigrateVersion? {
        return Version3(db)
    }

    override fun getVersion(): Int {
        return 2
    }

    override fun exec() {
        val createNewTableFriend = QUERY_CREATE_FRIEND_TABLE_NEW
        db.execSQL(createNewTableFriend)

        val transferDatasBetweenTablesFriend = QUERY_TRANSFER_DATA_BETWEEN_TABLES_FRIEND
        db.execSQL(transferDatasBetweenTablesFriend)

        val dropTable = QUERY_DROP_FRIEND_TABLE
        db.execSQL(dropTable)

        val renameTableNew = QUERY_RENAME_TABLE_FRIEND
        db.execSQL(renameTableNew)
    }
}