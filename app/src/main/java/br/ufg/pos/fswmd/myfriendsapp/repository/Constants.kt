package br.ufg.pos.fswmd.myfriendsapp.repository

val DATABASE_NAME = "friends.db"
val DATABASE_VERSION = 1

val FRIEND_TABLE_NAME = "friend"
val KEY_ID = "id"
val KEY_NAME = "name"
val KEY_NICKNAME = "nickname"
val KEY_DESCRIPTION = "description"

val QUERY_CREATE_FRIENDS_TABLE = "CREATE TABLE $FRIEND_TABLE_NAME " +
        "($KEY_ID LONG PRIMARY KEY, " +
        "$KEY_NAME TEXT NOT NULL, " +
        "$KEY_NICKNAME TEXT, " +
        "$KEY_DESCRIPTION TEXT" +
        ")"

val QUERY_DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS $FRIEND_TABLE_NAME"