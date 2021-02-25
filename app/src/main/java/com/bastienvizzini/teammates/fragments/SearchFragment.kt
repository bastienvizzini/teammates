package com.bastienvizzini.teammates.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.bastienvizzini.teammates.R
import com.bastienvizzini.teammates.viewmodel.MainViewModel


class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.run {
            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Throwable("Invalid activity")
        viewModel.updateActionBarTitle(getString(R.string.search_title))
    }

}