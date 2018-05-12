package br.ufg.pos.fswmd.myfriendsapp.repository.migrations

import android.database.sqlite.SQLiteDatabase
import br.ufg.pos.fswmd.myfriendsapp.repository.*

class Version2(
        private val db: SQLiteDatabase
    ): AbstractMigrateVersionChain(2) {

    private val QUERY_CREATE_FRIEND_TABLE_NEW = "CREATE TABLE ${FRIEND_TABLE_NAME + "_new"} " +
            "($KEY_ID INTEGER PRIMARY KEY, " +
            "$KEY_NAME TEXT NOT NULL, " +
            "$KEY_NICKNAME TEXT, " +
            "$KEY_DESCRIPTION TEXT, " +
            "$KEY_TIME_CREATED LONG NOT NULL" +
            ")"
    private val QUERY_TRANSFER_DATA_BETWEEN_TABLES_FRIEND = "INSERT INTO ${FRIEND_TABLE_NAME + "_new"}($KEY_NAME, $KEY_NICKNAME, $KEY_DESCRIPTION, $KEY_TIME_CREATED) " +
            "SELECT $KEY_NAME, $KEY_NICKNAME, $KEY_DESCRIPTION, $KEY_TIME_CREATED from $FRIEND_TABLE_NAME"

    private val QUERY_DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS $FRIEND_TABLE_NAME"
    private val QUERY_RENAME_TABLE_FRIEND = "ALTER TABLE ${FRIEND_TABLE_NAME + "_new"} RENAME TO $FRIEND_TABLE_NAME"

    override fun getNext(): MigrateVersion? {
        return Version3(db)
    }

    override fun exec() {
        db.execSQL(QUERY_CREATE_FRIEND_TABLE_NEW)

        db.execSQL(QUERY_TRANSFER_DATA_BETWEEN_TABLES_FRIEND)

        db.execSQL(QUERY_DROP_FRIEND_TABLE)

        db.execSQL(QUERY_RENAME_TABLE_FRIEND)
    }
}