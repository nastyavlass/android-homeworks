package com.example.myapplication

import android.content.Context

class Validator(private val context: Context) {
    fun checkEmail(email: String): String? {
        return if ((email.length < 6) or (!(email.contains("@"))))
            context.getString(R.string.email_error)
        else
            null
    }
    fun checkPassword(pass: String): String? {
        return if (pass.length < 8)
            context.getString(R.string.password_error)
        else
            null
    }
    fun checkPasswordEquality(pass: String, repeat_pass: String): String? {
        return if (pass != repeat_pass)
            context.getString(R.string.error_confirm_password)
        else
            null
    }
    fun checkName(name: String): String? {
        return if (name.length < 4)
            context.getString(R.string.error_empty_name)
        else
            null
    }
}
