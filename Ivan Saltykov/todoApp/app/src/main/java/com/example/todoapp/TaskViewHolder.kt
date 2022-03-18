package com.example.app

import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTaskBinding
import java.time.format.DateTimeFormatter

class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(task: Task, listener: TasksAdapter.ListenerDataBase) = with(binding) {
        textViewItemTaskName.text = task.nameTask
        textViewItemTaskTime.text = task.timeGenerationTask
            .format(DateTimeFormatter.ofPattern("HH:mm dd.MM.y"))
        checkBoxItemTask.isChecked = task.accomplishmentTask
        root.setOnClickListener {
            binding.checkBoxItemTask.isChecked = !binding.checkBoxItemTask.isChecked
            task.accomplishmentTask = binding.checkBoxItemTask.isChecked
            listener.upgradeTask(task)
        }
    }
}
