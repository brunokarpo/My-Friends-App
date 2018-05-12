package br.ufg.pos.fswmd.myfriendsapp.repository

const val DATABASE_NAME = "friends.db"
const val DATABASE_VERSION = 3

const val FRIEND_TABLE_NAME = "friend"
const val KEY_ID = "id"
const val KEY_NAME = "name"
const val KEY_NICKNAME = "nickname"
const val KEY_DESCRIPTION = "description"
const val KEY_TIME_CREATED = "created_date"
const val KEY_PHOTO_URL = "photo_url"

const val QUERY_CREATE_FRIENDS_TABLE = "CREATE TABLE $FRIEND_TABLE_NAME " +
        "($KEY_ID INTEGER PRIMARY KEY, " +
        "$KEY_NAME TEXT NOT NULL, " +
        "$KEY_NICKNAME TEXT, " +
        "$KEY_DESCRIPTION TEXT, " +
        "$KEY_PHOTO_URL TEXT, " +
        "$KEY_TIME_CREATED LONG NOT NULL" +
        ")"