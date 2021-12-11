package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val received = intent.extras?.getString("Email")
            ProfileHomeFragment
        fragment.email = received
        binding.bottomNavigationViewHome.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.menuFragmentHomeProfile -> {
                    supportFragmentManager
                        .beginTransaction()
                }
                R.id.menuFragmentHomeTasksList -> {
                    supportFragmentManager
                        .beginTransaction()
                }
            }
            true
        }
    }
}
