package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonMain.setOnClickListener {
            val valid = Validation()
            val email = binding.editTextMainEmail.text.toString()
            val password = binding.editTextMainPassword.text.toString()
            when {
                valid.checkEmail(email) -> {
                    binding.editTextMainEmail.error = getString(R.string.email_error)
                }
                valid.checkPassword(password) -> {
                    binding.editTextMainPassword.error = getString(R.string.password_error)
                }
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("Email", email)
                    startActivity(intent)
                }
            }
        }
        binding.textMainLink.setOnClickListener {
            val intentReg = Intent(this, RegistrationActivity::class.java)
            startActivity(intentReg)
        }
    }
}