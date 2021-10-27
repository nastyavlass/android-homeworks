package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val valid = validation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val email = binding.textInputEditText.text.toString()
            val password = binding.textInputEditText2.text.toString()

            when {
                valid.ValEmail2(email) -> binding.textInputEditText.error="!"
                valid.ValEmail1(email) -> binding.textInputEditText.error="!"
                valid.ValPass(password) -> binding.textInputEditText2.error="!"
                else -> {
                    Toast.makeText(this, "Succeeed!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Home::class.java)
                    intent.putExtra("Email", email)
                    startActivity(intent)
                }
            }
        }
        binding.textView4.setOnClickListener {
            val intentReg = Intent(this, Registration::class.java)
            startActivity(intentReg)
        }
    }
}