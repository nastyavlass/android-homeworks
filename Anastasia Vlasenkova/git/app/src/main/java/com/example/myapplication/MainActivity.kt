package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val valid = Validation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLog.setOnClickListener {
            val email = binding.editTextLogEmail.text.toString()
            val password = binding.editTextLogPass.text.toString()

            when {
//                valid.val_email2(email) -> binding.editTextLogEmail.error="!"
                valid.val_email1(email) -> binding.editTextLogEmail.error="!"
                valid.val_pass(password) -> binding.editTextLogPass.error="!"
                else -> {
                    Toast.makeText(this, "Succeed!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Home::class.java)
                    intent.putExtra("Email", email)
                    startActivity(intent)
                }
            }
        }
        binding.textLogSign.setOnClickListener {
            val intentReg = Intent(this, Registration::class.java)
            startActivity(intentReg)
        }
    }
}