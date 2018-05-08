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
        val create_friend_table = QUERY_CREATE_FRIENDS_TABLE

        db?.execSQL(create_friend_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val drop_table = QUERY_DROP_FRIEND_TABLE

        db?.execSQL(drop_table)
    }

    override fun save(friend: Friend) {
        var db: SQLiteDatabase = writableDatabase

        var values: ContentValues = ContentValues()
        values.put(KEY_NAME, friend.name)
        values.put(KEY_NICKNAME, friend.nickname)
        values.put(KEY_DESCRIPTION, friend.description)

        db.insert(FRIEND_TABLE_NAME, null, values)

        db.close()
    }
}