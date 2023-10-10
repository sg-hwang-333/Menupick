package com.example.menupick

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class FoodHome : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)


//        Bottom bar
        val bestbutton : Button = findViewById(R.id.bar_bestBtn)
        bestbutton.setOnClickListener {
            val intent = Intent(this, Best::class.java)
            startActivity(intent)
        }
        val roulettebutton : Button = findViewById(R.id.bar_rouletteBtn)
        roulettebutton.setOnClickListener {
            val intent = Intent(this, Roulette::class.java)
            startActivity(intent)
        }
    }
}