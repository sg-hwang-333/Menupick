package com.example.menupick

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class FoodHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val favorite_food_view : TextView= findViewById(R.id.favorite_food_view)
        favorite_food_view.setOnClickListener {
            val intent = Intent(this, Favorite_food::class.java)
            startActivity(intent)
        }

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