package com.example.bmicalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var welcomeTextView:TextView
    lateinit var welcomeButton:Button
    lateinit var welcomeImage:ImageView
    var loading:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeTextView = findViewById(R.id.welcomeTextView)
        welcomeButton = findViewById(R.id.welcomeButton)
        welcomeImage = findViewById(R.id.welcomeImageView)

        welcomeButton.setOnClickListener {
                loading = true
                welcomeTextView.text = getString(R.string.main_activity_click_welcome)
                //cambia la imagen:
                // welcomeImage.setImageResource(R.drawable.image2)
                //Imagen transparente
                welcomeImage.setImageResource(android.R.color.transparent)
                println(loading)
        }
    }

}