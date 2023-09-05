package com.example.menupick

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Best : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best)

//        Bottom bar
        val foodhomebutton : Button = findViewById(R.id.bar_foodBtn)
        foodhomebutton.setOnClickListener {
            val intent = Intent(this, FoodHome::class.java)
            startActivity(intent)
        }
        val roulettebutton : Button = findViewById(R.id.bar_rouletteBtn)
        roulettebutton.setOnClickListener {
            val intent = Intent(this, Roulette::class.java)
            startActivity(intent)
        }
    }
}