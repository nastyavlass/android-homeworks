package com.example.app

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTaskBinding

class TasksAdapter(
    private val listener: ListenerDataBase
) : RecyclerView.Adapter<TaskViewHolder>() {
    private var items = mutableListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(tasks: List<Task>) {
        items.clear()
        items.addAll(tasks)
        notifyDataSetChanged()
    }

    fun addItem(task: Task) {
        items.add(task)
        notifyItemInserted(items.lastIndex)
    }

    interface ListenerDataBase {
        fun upgradeTask(task: Task)
    }
}
