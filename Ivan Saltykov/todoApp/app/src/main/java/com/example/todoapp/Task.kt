package com.example.app

import android.os.Parcelable
import java.time.LocalDateTime
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    val id: Int,
    val nameTask: String,
    val timeGenerationTask: LocalDateTime,
    var accomplishmentTask: Boolean
) : Parcelable
