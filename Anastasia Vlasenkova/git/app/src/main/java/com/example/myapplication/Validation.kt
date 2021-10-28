package com.example.myapplication

class Validation {

    fun val_email1(email : String) : Boolean{
        return ((email.length < 6) && (!(email.contains("@"))))
    }
//    fun val_email2 (em: String) : Boolean{
//        return (!(em.contains("@")))
//    }
    fun val_pass (pass: String) : Boolean{
        return (pass.length < 8)
    }
    fun val_equal_pass(pass1: String, pass2: String) : Boolean{
        return pass1 != pass2
    }
    fun val_name(name: String) : Boolean{
        return name.isEmpty()
    }
}