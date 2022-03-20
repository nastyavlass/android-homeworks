package com.example.todoapp

import android.content.Context

class PreferencesManager(context: Context) {
    companion object {
        private const val PREFERENCES_NAME = "LoginAndPassword"
        private const val LOGIN_KEY = "login"
    }
    private val preferencesSingIn = context
        .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    var login: String
        get() = preferencesSingIn.getString(LOGIN_KEY, null) ?: ""
        set(value) = preferencesSingIn
            .edit()
            .putString(LOGIN_KEY, value)
            .apply()

    fun clearPreferences() {
        preferencesSingIn
            .edit()
            .clear()
            .apply()
    }
}
