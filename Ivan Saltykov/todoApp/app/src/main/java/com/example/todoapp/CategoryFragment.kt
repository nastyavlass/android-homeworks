package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.Task
import com.example.app.TasksAdapter
import com.example.todoapp.databinding.FragmentCategoryBinding
import java.time.LocalDateTime

class CategoryFragment : Fragment(), TasksAdapter.ListenerDataBase {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var dataBaseTask: DatabaseTask
    private lateinit var adapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBaseTask = DatabaseTask(requireContext())
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        adapter = TasksAdapter(this)
        binding.recyclelViewCategory.adapter = adapter
        adapter.submitList(dataBaseTask.getTasks())
        binding.floatingActionButtonCategory.setOnClickListener {
            dataBaseTask.addTask("New task", LocalDateTime.now(), false)
            adapter.submitList(dataBaseTask.getTasks())
            binding.recyclelViewCategory.layoutManager?.scrollToPosition(adapter.itemCount - 1)
        }
        return binding.root
    }

    override fun upgradeTask(task: Task) {
        dataBaseTask.upgradeTask(task.id, task)
    }
}
