package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate((layoutInflater))
        setContentView(binding.root)
        binding.buttonRegistration.setOnClickListener {
            val valid = Validator(this)
            val email = binding.editTextRegistrationEmail.text.toString()
            val password = binding.editTextRegistrationPassword.text.toString()
            val passwordRepeat = binding.editTextRegistrationConfirm.text.toString()
            val name = binding.editTextRegistrationName.text.toString()
            binding.editTextRegistrationConfirm.error = valid.checkPasswordEquality(password, passwordRepeat)
            binding.editTextRegistrationEmail.error = valid.checkEmail(email)
            binding.editTextRegistrationName.error = valid.checkName(name)
            binding.editTextRegistrationPassword.error = valid.checkPassword(password)
            if (valid.checkEmail(email) == null && valid.checkName(name) == null &&
            valid.checkPassword(password) == null && valid.checkPasswordEquality(password, passwordRepeat) == null){
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Email", email)
                startActivity(intent)
                }
            }
        binding.textRegistrationLink.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }
    }
}
