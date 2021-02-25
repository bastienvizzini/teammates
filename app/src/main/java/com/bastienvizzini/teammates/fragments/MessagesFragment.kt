package com.bastienvizzini.teammates.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bastienvizzini.teammates.R
import com.bastienvizzini.teammates.adapters.MessageListAdapter
import com.bastienvizzini.teammates.models.Message
import com.bastienvizzini.teammates.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_messages.*

class MessagesFragment : Fragment() {

    companion object {
        fun newInstance() = MessagesFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mMessageList: MutableList<Message> = mutableListOf()

        for (i in 0..9) {
            val message = Message("Hey man, I'm message ${i+1}", userSenderUid = "User ${i+1}")
            mMessageList.add(message)
        }

        val mAdapter = MessageListAdapter(requireContext(), mMessageList)
        messagesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        messagesRecyclerView.adapter = mAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.run {
            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Throwable("Invalid activity")
        viewModel.updateActionBarTitle(getString(R.string.messages_title))
    }

}