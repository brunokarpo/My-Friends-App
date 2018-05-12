package br.ufg.pos.fswmd.myfriendsapp.addfriend.activity

interface AddFriendView {

    fun showMessageNameRequired()
    fun showMessageFriendSaveSuccessfully()
    fun clearFields()
    fun finishActivity()
}


interface AddFriendPresenter{
    fun saveFriend(name: String?, nickname: String?, description: String?, photoUrl: String?)
}