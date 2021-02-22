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
     //  val rollNumber: TextView = findViewById(R.id.textViewRoll)

        rollButton.setOnClickListener {
            Toast.makeText(this,"Dice Rolled ",Toast.LENGTH_LONG).show()
             rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val rollNumber: TextView = findViewById(R.id.textViewRoll)
        rollNumber.text = diceRoll.toString()


    }


}
class Dice(private val  numSides:Int){

    fun roll():Int{
        return (1..numSides).random()
    }
}