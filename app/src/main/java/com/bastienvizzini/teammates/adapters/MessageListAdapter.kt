package com.bastienvizzini.teammates.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bastienvizzini.teammates.R
import com.bastienvizzini.teammates.models.Message

class MessageListAdapter(context: Context, messageList: MutableList<Message>): RecyclerView.Adapter<MessageListAdapter.MessagesViewHolder>() {

    private var mMessageList = messageList
    private var mInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val itemView = mInflater.inflate(R.layout.item_message_list, parent, false)
        return MessagesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mMessageList.size
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        val currentMessage = mMessageList[position]

        // To be modified
        holder.usernameTextView.text = currentMessage.userSenderUid
        holder.messageTextView.text = currentMessage.message
        // To be modified
        holder.pictureImageView.setImageResource(R.drawable.ic_person)
    }


    inner class MessagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.usernameMessageListItem)
        val messageTextView: TextView = itemView.findViewById(R.id.messageMessageListItem)
        val pictureImageView: ImageView = itemView.findViewById(R.id.pictureMessageListItem)
    }

}