package com.bastienvizzini.teammates

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    private lateinit var bottomNavigation: BottomNavigationView

    // Fragments
    private val mMessagesFragment = MessagesFragment()
    private val mExploreFragment = ExploreFragment()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigation = view.findViewById(R.id.bottom_nav_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(bottomNavMethod)

        // To start the app with right tab and keeping active tab with screen rotation
        if (savedInstanceState == null) {
            fragmentManager?.beginTransaction()?.replace(R.id.tab_container, mMessagesFragment)?.commit()
        }
    }

    private val bottomNavMethod = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->

        var fragment = Fragment()
        when (menuItem.itemId) {
            R.id.messages -> {
                fragment = mMessagesFragment
            }
            R.id.explore -> {
                fragment = mExploreFragment
            }
        }

        fragmentManager?.beginTransaction()?.replace(R.id.tab_container, fragment)?.commit()

        true
    }

}