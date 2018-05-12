package br.ufg.pos.fswmd.myfriendsapp.repository.migrations

abstract class AbstractMigrateVersionChain(
        private val version: Int
    ): MigrateVersion {

    override fun migrate(oldVersion: Int) {
        if (oldVersion < getVersion()) {
            exec()
            getNext()?.migrate(oldVersion)
        }
    }

    private fun getVersion(): Int {
        return version
    }

    internal abstract fun getNext(): MigrateVersion?

    internal abstract fun exec()


}