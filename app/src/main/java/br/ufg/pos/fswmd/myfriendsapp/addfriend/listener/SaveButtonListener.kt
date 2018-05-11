package br.ufg.pos.fswmd.myfriendsapp.addfriend.listener

import android.view.View
import android.widget.EditText
import br.ufg.pos.fswmd.myfriendsapp.addfriend.activity.AddFriendPresenter

class SaveButtonListener(
        private val addFriendPresenter: AddFriendPresenter,
        private val nameEdit: EditText? = null,
        private val nickanameEdit: EditText? = null,
        private val descriptionEdit: EditText? = null,
        private val photoUrl: String? = null
    ): View.OnClickListener {

    override fun onClick(v: View?) {
        var name = nameEdit?.text.toString()
        var nickname = nickanameEdit?.text.toString()
        var description = descriptionEdit?.text.toString()

        addFriendPresenter.saveFriend(name, nickname, description, photoUrl)
    }
}