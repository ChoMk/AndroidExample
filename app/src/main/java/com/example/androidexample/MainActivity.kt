package com.example.androidexample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var numRendered = 0

    private lateinit var resultText: TextView
    private lateinit var plusButton: Button
    private lateinit var minusButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        resultText = findViewById(R.id.result)
        plusButton = findViewById(R.id.plus_button)
        minusButton = findViewById(R.id.minus_button)

        plusButton.setOnClickListener {
            numRendered++
            resultText.text = numRendered.toString()
        }
        minusButton.setOnClickListener {
            numRendered--
            resultText.text = numRendered.toString()
        }

    }

}