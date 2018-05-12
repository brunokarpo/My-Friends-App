package br.ufg.pos.fswmd.myfriendsapp.repository.migrations

abstract class AbstractMigrateVersionChain: MigrateVersion {

    override fun migrate(oldVersion: Int) {
        if (oldVersion < getVersion()) {
            exec()
            getNext()?.migrate(oldVersion)
        }
    }

    internal abstract fun getNext(): MigrateVersion?

    internal abstract fun getVersion(): Int

    internal abstract fun exec()


}