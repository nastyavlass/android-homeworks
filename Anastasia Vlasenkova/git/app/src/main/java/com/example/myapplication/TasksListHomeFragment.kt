package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeTasksListBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.time.LocalDateTime
@RequiresApi(Build.VERSION_CODES.O)

class TasksListHomeFragment : Fragment() {
    lateinit var binding: FragmentHomeTasksListBinding
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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeTasksListBinding.inflate(inflater, container, false)
        binding.viewPager?.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.pager_work)
                1 -> getString(R.string.pager_entertainment)
                2 -> getString(R.string.pager_study)
                else -> null
            }
        }.attach()
        return binding.root
    }
}
