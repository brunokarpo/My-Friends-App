package br.ufg.pos.fswmd.myfriendsapp.repository

const val DATABASE_NAME = "friends.db"
const val DATABASE_VERSION = 1

const val FRIEND_TABLE_NAME = "friend"
const val KEY_ID = "id"
const val KEY_NAME = "name"
const val KEY_NICKNAME = "nickname"
const val KEY_DESCRIPTION = "description"
const val KEY_TIME_CREATED = "created_date"

const val QUERY_CREATE_FRIENDS_TABLE = "CREATE TABLE $FRIEND_TABLE_NAME " +
        "($KEY_ID LONG PRIMARY KEY, " +
        "$KEY_NAME TEXT NOT NULL, " +
        "$KEY_NICKNAME TEXT, " +
        "$KEY_DESCRIPTION TEXT, " +
        "$KEY_TIME_CREATED LONG NOT NULL" +
        ")"

const val QUERY_DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS $FRIEND_TABLE_NAME"