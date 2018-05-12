package br.ufg.pos.fswmd.myfriendsapp.repository.migrations

interface MigrateVersion {

    fun migrate(oldVersion: Int)

}