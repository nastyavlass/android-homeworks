package com.example.todoapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.app.Task
import java.time.LocalDateTime

class DatabaseTask(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    companion object {
        private const val DATABASE_NAME = "DataBaseTask"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "Tasks"
        private const val NAME_TASK_COLUMN = "Task"
        private const val TIME_COLUMN = "Time"
        private const val CONDITION_COLUMN = "Сondition"
        private const val ID_COLUMN = "id"
    }
// AUTOINCREMENT
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE $TABLE_NAME(" +
                "$ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$NAME_TASK_COLUMN TEXT, " +
                "$TIME_COLUMN NUMERIC, " +
                "$CONDITION_COLUMN NUMERIC)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addTask(nameTask: String, timeGenerationTask: LocalDateTime, accomplishmentTask: Boolean) {
        writableDatabase.insert(
            TABLE_NAME,
            null,
            ContentValues().apply {
                put(NAME_TASK_COLUMN, nameTask)
                put(TIME_COLUMN, timeGenerationTask.toString())
                put(CONDITION_COLUMN, accomplishmentTask)
            }
        )
    }
    fun getTasks(): List<Task> {
        val cursor = readableDatabase.query(
            TABLE_NAME,
            arrayOf(ID_COLUMN, NAME_TASK_COLUMN, TIME_COLUMN, CONDITION_COLUMN),
            null,
            null,
            null,
            null,
            null,
        )
        val tasks = mutableListOf<Task>()

        with(cursor) {
            if (moveToFirst()) {
                do {
                    tasks.add(
                        Task(
                            id = getInt(getColumnIndexOrThrow(ID_COLUMN)),
                            nameTask = getString(getColumnIndexOrThrow(NAME_TASK_COLUMN)),
                            timeGenerationTask = LocalDateTime.parse(
                                getString(getColumnIndexOrThrow(TIME_COLUMN))
                            ),
                            accomplishmentTask = getInt(getColumnIndexOrThrow(CONDITION_COLUMN)) > 0
                        )
                    )
                } while (moveToNext())
            }
            close()
        }
        close()
        return tasks
    }

    fun upgradeTask(id: Int, task: Task) {
        writableDatabase.update(
            TABLE_NAME,
            ContentValues().apply {
                put(NAME_TASK_COLUMN, task.nameTask)
                put(TIME_COLUMN, task.timeGenerationTask.toString())
                put(CONDITION_COLUMN, task.accomplishmentTask)
            },
            "id = ?",
            arrayOf(id.toString())
        )
    }
}
