package br.ufg.pos.fswmd.myfriendsapp.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.ufg.pos.fswmd.myfriendsapp.model.Friend

class FriendDatabaseHandler(context: Context):
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION),
        FriendRepository {

    override fun onCreate(db: SQLiteDatabase?) {
        val createFriendTable = QUERY_CREATE_FRIENDS_TABLE

        db?.execSQL(createFriendTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTable = QUERY_DROP_FRIEND_TABLE

        db?.execSQL(dropTable)
    }

    override fun save(friend: Friend) {
        var db: SQLiteDatabase = writableDatabase

        var values = ContentValues()
        values.put(KEY_NAME, friend.name)
        values.put(KEY_NICKNAME, friend.nickname)
        values.put(KEY_DESCRIPTION, friend.description)
        values.put(KEY_TIME_CREATED, System.currentTimeMillis())

        db.insert(FRIEND_TABLE_NAME, null, values)

        db.close()
    }
}