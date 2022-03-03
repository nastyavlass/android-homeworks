package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentPagerBinding
import java.time.LocalDateTime

class PagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentPagerBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        val adapter = TasksAdapter()
        when (position) {
            0 -> {
                binding.recyclerViewPager.adapter = adapter
                adapter.submitList(TasksDatabase().tasks)
            }
            1 -> {
                binding.recyclerViewPager.adapter = adapter
                adapter.submitList(TasksDatabase().twoTasks)
            }
            2 -> {
                binding.recyclerViewPager.adapter = adapter
                adapter.submitList(TasksDatabase().threeTasks)
            }
        }
        binding.newTasksButton.setOnClickListener {
            adapter.addItem(
                Task(
                    name = "meeting at 15:00",
                    time = LocalDateTime.now()
                )
            )
        }
        return binding.root
    }
}
