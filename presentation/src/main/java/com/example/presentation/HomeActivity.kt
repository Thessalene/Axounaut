package com.example.presentation

import Constants.ANALYSIS
import Constants.COMMANDS
import Constants.FRAGMENT_TO_SHOW
import Constants.STOCK
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presentation.databinding.ActivityHomeBinding
import splitties.views.onClick

class  HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private var fragmentToShow : String = COMMANDS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewHeader.onClick {
            fragmentToShow = COMMANDS
            goToMainActivity()
        }

        binding.cvAnalysis.onClick {
            fragmentToShow = ANALYSIS
            goToMainActivity()
        }

        binding.cvStock.onClick {
            fragmentToShow = STOCK
            goToMainActivity()
        }


    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java).apply {
            putExtra(FRAGMENT_TO_SHOW, fragmentToShow)
        })
    }
}