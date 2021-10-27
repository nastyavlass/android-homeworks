package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityRegistrationBinding
import com.example.myapplication.databinding.ActivitySplashScreenBinding

class Registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    val valid = validation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate((layoutInflater))
        setContentView(binding.root)
        binding.button2.setOnClickListener {
            val emailreg = binding.textInputEditText4.text.toString()
            val password1 = binding.textInputEditText5.text.toString()
            val password2 = binding.textInputEditText6.text.toString()
            val name = binding.textInputEditText3.text.toString()
            when {
                valid.ValName(name) -> binding.textInputEditText3.error="!"
                valid.ValEmail2(emailreg) -> binding.textInputEditText4.error="!"
                valid.ValEmail1(emailreg) -> binding.textInputEditText4.error="!"
                valid.ValPass(password1) -> binding.textInputEditText5.error="!"
                valid.ValRav(password1, password2) -> binding.textInputEditText6.error="!"
                else -> {
                    Toast.makeText(this, "Succeeed!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Home::class.java)
                    intent.putExtra("Email", emailreg)
                    startActivity(intent)
                }
            }
        }
        binding.textView11.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }
    }
}