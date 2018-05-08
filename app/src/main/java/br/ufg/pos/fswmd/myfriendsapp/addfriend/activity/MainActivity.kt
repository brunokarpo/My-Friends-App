package br.ufg.pos.fswmd.myfriendsapp.addfriend.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.ufg.pos.fswmd.myfriendsapp.R

class MainActivity : AppCompatActivity(), AddFriendView {

    private var presenter: AddFriendPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = AddFriendPresenterImpl(this)
    }
}
