package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeTasksListBinding
import com.google.android.material.tabs.TabLayoutMediator

class TasksListHomeFragment : Fragment() {
    lateinit var binding: FragmentHomeTasksListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeTasksListBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = PagerAdapter(this)
        return binding.root
    }
}
