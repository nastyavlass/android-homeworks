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
        val fragment = supportFragmentManager.findFragmentById(binding.container.id) as
            ProfileHomeFragment
        fragment.email = received
        binding.bottomNavigationViewHome.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.menuFragmentHomeProfile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, ProfileHomeFragment())
                        .commit()
                    Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show()
                }
                R.id.menuFragmentHomeTasksList -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, TasksListHomeFragment())
                        .commit()
                    Toast.makeText(this, "tasks", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
}
