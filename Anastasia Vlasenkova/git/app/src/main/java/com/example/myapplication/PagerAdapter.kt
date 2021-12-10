package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return PagerFragment(position)
            1 -> return PagerFragment(position)
            2 -> return PagerFragment(position)
            else -> return PagerFragment(5)
        }
    }
}



