package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonMain.setOnClickListener {
            val valid = Validator(this)
            val email = binding.editTextMainEmail.text.toString()
            val password = binding.editTextMainPassword.text.toString()
            binding.editTextMainEmail.error = valid.checkEmail(email)
            binding.editTextMainPassword.error = valid.checkPassword(password)
            if (valid.checkEmail(email) == null && valid.checkPassword(password) == null) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Email", email)
                startActivity(intent)
            }
        }
        binding.textMainLink.setOnClickListener {
            val intentReg = Intent(this, RegistrationActivity::class.java)
            startActivity(intentReg)
        }
    }
}
