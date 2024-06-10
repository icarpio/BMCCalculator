package com.example.bmicalculator

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.slider.Slider
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var heightEditText: TextView
    lateinit var weightEditText: TextView
    lateinit var minusButton: Button
    lateinit var addButton: Button
    lateinit var resultTextView: TextView
    lateinit var healthyTextView: TextView
    lateinit var calculateButton: Button
    lateinit var imageView:ImageView
    lateinit var heightSlider:Slider

    var height: Float = 0.0F
    var weight: Float = 60.0F


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "BMI Calculator"

        heightEditText = findViewById(R.id.heightEditText)
        heightSlider = findViewById(R.id.heightSlider)
        weightEditText = findViewById(R.id.weightEditText)
        minusButton = findViewById(R.id.minusButton)
        addButton = findViewById(R.id.addButton)
        healthyTextView = findViewById(R.id.healthyTextView)
        resultTextView = findViewById(R.id.resultTextView)
        calculateButton = findViewById(R.id.calculateButton)
        imageView = findViewById(R.id.imageView)

        imageView.visibility = View.INVISIBLE

        //Controles del peso
        minusButton.setOnClickListener {
            weight--
            setWeight()
        }

        addButton.setOnClickListener {
            weight++
            setWeight()
        }
        heightSlider.addOnChangeListener { _, value, _ ->
            height = value
            setHeight()
            Log.i("Slider", height.toInt().toString())
        }
        //Calcular resultado
        calculateButton.setOnClickListener {
            val result = weight / (height / 100f).pow(2)
            val formated = String.format("%.2f", result)
            resultTextView.text = formated

            var color = 0

            when (result) {
                in 0.0..18.5 -> {
                    healthyTextView.text = getString(R.string.under_weight)
                    healthyTextView.setTextColor(Color.parseColor("#FF9933"))
                    imageView.visibility = View.GONE

                }

                in 18.5..24.9 -> {
                    healthyTextView.text = getString(R.string.normal)
                    healthyTextView.setTextColor(Color.parseColor("#33FF36"))
                    imageView.visibility = View.GONE
                }

                in 25.0..29.9 -> {
                    healthyTextView.text = getString(R.string.overweight)
                    healthyTextView.setTextColor(Color.parseColor("#33FF36"))
                    imageView.visibility = View.GONE
                }

                else -> {
                    healthyTextView.text = getString(R.string.obesity)
                    color = getColor(R.color.weight_red)
                    healthyTextView.setTextColor(color)
                    imageView.visibility = View.VISIBLE
                }
            }
        }
    }

    fun setWeight() {
        //weightEditText.text = "$weight Kg"
        weightEditText.text = getString(R.string.weight_text, weight.toInt())
    }
    fun setHeight() {
        var formated = height.toInt().toString()
        heightEditText.text = "$formated cm"
        //heightEditText.text = getString(R.string.height_text, height)
    }


}