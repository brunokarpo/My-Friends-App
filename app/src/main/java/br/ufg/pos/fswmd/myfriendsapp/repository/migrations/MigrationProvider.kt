package br.ufg.pos.fswmd.myfriendsapp.repository.migrations

import android.database.sqlite.SQLiteDatabase

class MigrationProvider {

    companion object {
        fun getMigration(db: SQLiteDatabase): MigrateVersion {
            return Version2(db)
        }
    }
}