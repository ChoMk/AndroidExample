package com.example.androidexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.sample_text_view).setOnClickListener {
            Toast.makeText(this, "text click", Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.sample_button_view).setOnClickListener {
            Toast.makeText(this, "button click", Toast.LENGTH_SHORT).show()
        }
    }
}