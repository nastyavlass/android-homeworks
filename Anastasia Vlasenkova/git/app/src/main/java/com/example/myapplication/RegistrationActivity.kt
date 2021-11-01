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
            val valid = Validation()
            val email = binding.editTextRegistrationEmail.text.toString()
            val password = binding.editTextRegistrationPassword.text.toString()
            val passwordRepeat = binding.editTextRegistrationConfirm.text.toString()
            val name = binding.editTextRegistrationName.text.toString()
            when {
                valid.checkName(name) -> {
                    binding.editTextRegistrationName.error = getString(R.string.error_empty_name)
                }
                valid.checkEmail(email) -> {
                    binding.editTextRegistrationEmail.error = getString(R.string.email_error)
                }
                valid.checkPassword(password) -> {
                    binding.editTextRegistrationPassword.error = getString(R.string.password_error)
                }
                valid.checkPasswordEquality(password, passwordRepeat) -> {
                    binding.editTextRegistrationConfirm.error =
                        getString(R.string.error_confirm_password)
                }
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("Email", email)
                    startActivity(intent)
                }
            }
        }
        binding.textRegistrationLink.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }
    }
}
