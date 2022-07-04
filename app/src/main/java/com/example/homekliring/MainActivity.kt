package com.example.homekliring


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.homekliring.databinding.ActivityMainBinding
import com.example.homekliring.ui.history.TrasferFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainACtivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainACtivityViewModel::class.java]


       with(binding){
           setupBottomNavigation()
           fab.setOnClickListener{
             supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_fragment, TrasferFragment())
                commit()}
            }


        }

    }


    private fun setupBottomNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(binding.navFragment.id) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }




}