package com.example.myapplication

import android.content.Context

class Validator(private val context: Context) {
    fun checkEmail(email: String): String? {
        if ((email.length < 6) or (!(email.contains("@"))))
            return context.getString(R.string.email_error)
        else
            return null
    }
    fun checkPassword(pass: String): String? {
        if (pass.length < 8)
            return context.getString(R.string.password_error)
        else
            return null
    }
    fun checkPasswordEquality(pass: String, repeat_pass: String): String? {
        if (pass != repeat_pass)
            return context.getString(R.string.error_confirm_password)
        else
            return null
    }
    fun checkName(name: String): String?{
        if (name.isEmpty())
            return context.getString(R.string.error_empty_name)
        else
            return null
    }
}

