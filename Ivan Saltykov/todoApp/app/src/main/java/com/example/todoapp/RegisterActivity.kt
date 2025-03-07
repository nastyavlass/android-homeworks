package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val preferences = PreferencesManager(this)
        binding.buttonRegister.setOnClickListener {
            val validator = Validator(this)
            val userPassword = binding.editTextRegisterPassword.text.toString()
            val userConfirmPassword = binding.editTextRegisterConfirmPassword.text.toString()
            val userEmail = binding.editTextRegisterEmail.text.toString()
            val userName = binding.editTextRegisterName.text.toString()
            binding.inputLayoutRegisterEmail.error = validator.checkEmail(userEmail)
            binding.inputLayoutRegisterPassword.error = validator.checkPassword(userPassword)
            binding.inputLayoutRegisterConfirmPassword.error =
                validator.checkConfirmPassword(userPassword, userConfirmPassword)
            binding.inputLayoutRegisterName.error = validator.checkName(userName)
            if (binding.inputLayoutRegisterPassword.error == null &&
                binding.inputLayoutRegisterEmail.error == null &&
                binding.inputLayoutRegisterConfirmPassword.error == null &&
                binding.inputLayoutRegisterName.error == null
            ) {
                preferences.login = userEmail
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Name", userEmail)
                startActivity(intent)
            }
        }
        binding.textViewRegisterSingIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
