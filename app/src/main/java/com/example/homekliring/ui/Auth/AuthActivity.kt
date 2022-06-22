package com.example.homekliring.ui.Auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homekliring.databinding.ActivityAuthBinding


class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}