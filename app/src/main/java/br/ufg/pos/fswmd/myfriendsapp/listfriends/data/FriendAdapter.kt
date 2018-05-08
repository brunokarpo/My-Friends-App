package br.ufg.pos.fswmd.myfriendsapp.listfriends.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.ufg.pos.fswmd.myfriendsapp.R
import br.ufg.pos.fswmd.myfriendsapp.model.Friend

class FriendAdapter(
        private val list: ArrayList<Friend>,
        private val context: Context
    ): RecyclerView.Adapter<FriendAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context)
                .inflate(R.layout.friend_row_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

        var friendName = itemView!!.findViewById(R.id.list_name_friend_text_id) as TextView
        var friendNickname = itemView!!.findViewById(R.id.list_nickname_friend_text_id) as TextView

        fun bindItem(friend: Friend) {
            friendName.text = friend.name
            friendNickname.text = friend.nickname
        }

    }

}