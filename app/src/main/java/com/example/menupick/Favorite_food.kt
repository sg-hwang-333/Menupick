package com.example.menupick

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Favorite_food : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_food)

        val backButton : ImageView = findViewById(R.id.before_btn)
        backButton.setOnClickListener {
            val intent = Intent(this, FoodHome::class.java)
            startActivity(intent)
        }


    }
}