package com.example.menupick

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class FoodHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)


//        Bottom bar

        val button : Button = findViewById(R.id.bar_rouletteBtn)
        button.setOnClickListener {
            val intent = Intent(this, Roulette::class.java)
            startActivity(intent)
        }
    }
}