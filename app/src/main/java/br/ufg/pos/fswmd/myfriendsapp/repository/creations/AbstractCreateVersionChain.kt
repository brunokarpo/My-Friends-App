package br.ufg.pos.fswmd.myfriendsapp.repository.creations

abstract class AbstractCreateVersionChain: CreateVersion {

    override fun create() {
        if (nextVersion() == null) {
            exec()
            return
        }
        nextVersion()?.create()
    }

    abstract fun nextVersion(): CreateVersion?

    abstract fun exec()
}