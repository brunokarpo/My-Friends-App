package br.ufg.pos.fswmd.myfriendsapp.addfriend.activity

interface AddFriendView {

    fun showMessageNameRequired()
    fun showMessageFriendSaveSuccessfully()
    fun clearFields()
    fun goToListFriendsActivity()
}


interface AddFriendPresenter{
    fun saveFriend(name: String?, nickname: String?, description: String?)
}