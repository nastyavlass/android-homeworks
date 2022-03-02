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
        val tasks = listOf(
            Task(
                name = "send a report",
                time = LocalDateTime.now()
            ),
            Task(
                name = "prepare documents in the archive",
                time = LocalDateTime.now()
            )
        )
        val twoTasks = listOf(
            Task(
                name = "buy a cactus",
                time = LocalDateTime.now()
            ),
            Task(
                name = "buy a book",
                time = LocalDateTime.now()
            )
        )
        val threeTasks = listOf(
            Task(
                name = "lecture at 18:00",
                time = LocalDateTime.now()
            ),
            Task(
                name = "make a presentation on philosophy",
                time = LocalDateTime.now()
            ),
            Task(
                name = "buy blocks for a notebook",
                time = LocalDateTime.now()
            ),
            Task(
                name = "pick up the certificate from the deconate",
                time = LocalDateTime.now()
            )
        )
        val adapter = TasksAdapter()
        when (position) {
            0 -> {
                binding.recyclerViewPager.adapter = adapter
                adapter.submitList(tasks)
            }
            1 -> {
                binding.recyclerViewPager.adapter = adapter
                adapter.submitList(twoTasks)
            }
            2 -> {
                binding.recyclerViewPager.adapter = adapter
                adapter.submitList(threeTasks)
            }
        }
        binding.newTasksButton.setOnClickListener {
            when (position) {
                0 -> adapter.addItem(
                    Task(
                        name = "meeting at 15:00",
                        time = LocalDateTime.now()
                    )
                )
                1 -> adapter.addItem(
                    Task(
                        name = "pick up the certificate from the deconate",
                        time = LocalDateTime.now()
                    )
                )
                2 -> adapter.addItem(
                    Task(
                        name = "learn 25 words",
                        time = LocalDateTime.now()
                    )
                )
            }
        }
        return binding.root
    }
}
