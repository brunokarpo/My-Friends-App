package br.ufg.pos.fswmd.myfriendsapp.model

import java.text.DateFormat
import java.util.*

class Friend(
        var name: String? = null,
        var nickname: String? = null,
        var description: String? = null,
        var photoUrl: String? = null,
        var timeCreated: Long? = null,
        var id: Int? = null
    ) {

    fun showHumanDate(): String {
        var dateFormat: java.text.DateFormat = DateFormat.getDateInstance()
        var formattedDate: String = dateFormat.format(Date(timeCreated!!).time)

        return "$formattedDate"
    }
}