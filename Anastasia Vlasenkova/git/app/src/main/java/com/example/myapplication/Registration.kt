package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    val valid = Validation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate((layoutInflater))
        setContentView(binding.root)
        binding.buttonReg.setOnClickListener {
            val emailreg = binding.edittextRegEmail.text.toString()
            val password1 = binding.editTextRegPass.text.toString()
            val password2 = binding.editTextRegConfPass.text.toString()
            val name = binding.editTextRegName.text.toString()
            when {
                valid.val_name(name) -> binding.editTextRegName.error="!"
//                valid.val_email2(emailreg) -> binding.inputLayoutRegEmail.error="!"
                valid.val_email1(emailreg) -> binding.edittextRegEmail.error="!"
                valid.val_pass(password1) -> binding.editTextRegPass.error="!"
                valid.val_equal_pass(password1, password2) -> binding.inputLayoutRegConfPass.error="!"
                else -> {
                    Toast.makeText(this, "Succeeed!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Home::class.java)
                    intent.putExtra("Email", emailreg)
                    startActivity(intent)
                }
            }
        }
        binding.textRegLogIn.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }
    }
}