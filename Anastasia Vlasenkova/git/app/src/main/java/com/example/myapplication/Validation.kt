package com.example.myapplication

class Validation {
    fun checkEmail(email : String) : Boolean{
        return ((email.length < 6) or (!(email.contains("@"))))
    }
    fun checkPassword(pass: String) : Boolean{
        return (pass.length < 8)
    }
    fun checkPasswordEquality(pass: String, repeat_pass: String) : Boolean{
        return pass != repeat_pass
    }
    fun checkName(name: String) : Boolean{
        return name.isEmpty()
    }
}