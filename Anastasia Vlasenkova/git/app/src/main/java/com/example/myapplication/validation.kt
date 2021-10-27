package com.example.myapplication

class validation {

    fun ValEmail1(em : String) : Boolean{
        return (em.length < 6)
    }
    fun ValEmail2 (em: String) : Boolean{
        return (!(em.contains("@")))
    }
    fun ValPass (pass: String) : Boolean{
        return (pass.length < 8)
    }
    fun ValRav(pass1: String, pass2: String) : Boolean{
        if(pass1 != pass2){
            return true
        }
        else{
            return false
        }
    }
    fun ValName(name: String) : Boolean{
        if(name.isEmpty()){
            return true
        } else{
            return false
        }
    }

}