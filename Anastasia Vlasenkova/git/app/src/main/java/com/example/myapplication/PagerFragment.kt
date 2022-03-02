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
                name = "Fkjldijlifdhh hfivhldfi vhldf hufvhdlfivhd " +
                        "hfuvhdlfivh hofvu hfdovohfvodifvhdif hoifvhldifv  hofuvhdlfivhfdlh",
                time = LocalDateTime.now()
            ),
            Task(
                name = "Fkfv  hofuvhdlfivhfdlh",
                time = LocalDateTime.now()
            ),
            Task(
                name = "Fkjldijllfivh hofvu hfdovohfvodifvhdif hoifvhldifv  hofuvhdlfivhfdlh",
                time = LocalDateTime.now()
            ),
            Task(
                name = "Fkjldijlifdhh hfivhldfi vhldf hufvhdlfivhd hfuvhdlfivh hfdlh",
                time = LocalDateTime.now()
            )
        )
        val twoTasks = listOf(
            Task(
                name = "Fyyh",
                time = LocalDateTime.now()
            ),
            Task(
                name = "Fyy7878t8f7tficith",
                time = LocalDateTime.now()
            )
        )
        val threeTasks = listOf(
            Task(
                name = "FYUFVLUYCC.C.",
                time = LocalDateTime.now()
            ),
            Task(
                name = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
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
                        name = "firstly",
                        time = LocalDateTime.now()
                    )
                )
                1 -> adapter.addItem(
                    Task(
                        name = "secondly",
                        time = LocalDateTime.now()
                    )
                )
                2 -> adapter.addItem(
                    Task(
                        name = "3",
                        time = LocalDateTime.now()
                    )
                )
            }
        }
        return binding.root
    }
}
