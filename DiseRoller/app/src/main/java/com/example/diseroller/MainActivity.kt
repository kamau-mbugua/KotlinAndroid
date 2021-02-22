package com.example.diseroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.buttonRoll)
        val rollNumber: TextView = findViewById(R.id.textViewRoll)

        rollButton.setOnClickListener {
            Toast.makeText(this,"Dice Roled",Toast.LENGTH_LONG).show()
        }
    }
}