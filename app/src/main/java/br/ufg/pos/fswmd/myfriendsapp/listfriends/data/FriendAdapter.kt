package br.ufg.pos.fswmd.myfriendsapp.listfriends.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.ufg.pos.fswmd.myfriendsapp.R
import br.ufg.pos.fswmd.myfriendsapp.listfriends.listeners.RetrieveFriendListener
import br.ufg.pos.fswmd.myfriendsapp.model.Friend
import com.squareup.picasso.Picasso

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
        var friendTimeCreated = itemView!!.findViewById(R.id.list_friend_since_value_text_id) as TextView
        var friendPhoto = itemView!!.findViewById(R.id.list_friend_photo_image_id) as ImageView

        fun bindItem(friend: Friend) {
            friendName.text = friend.name
            friendNickname.text = friend.nickname
            friendTimeCreated.text = friend.showHumanDate()

            if (TextUtils.isEmpty(friend.photoUrl).not()) {
                Picasso.get()
                        .load(friend.photoUrl)
                        .into(friendPhoto)
            }

            itemView.setOnClickListener(
                    RetrieveFriendListener(context, friend)
            )
        }

    }

}