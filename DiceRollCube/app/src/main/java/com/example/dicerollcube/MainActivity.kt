package com.example.dicerollcube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.buttonRoll)
        //  val rollNumber: TextView = findViewById(R.id.textViewRoll)

        rollButton.setOnClickListener {
            //Toast.makeText(this, "Dice Rolled ", Toast.LENGTH_LONG).show()
            rollDice()
        }
    }


    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        //This code calls the `setImageResource()`
        // method on the `ImageView`, passing the resource ID for the `dice_2` image.
        // This will update the `ImageView` on screen to display the `dice_2` image.
       /* diceImage.setImageResource(R.drawable.dice_2)*/

      when(diceRoll){
          1 -> diceImage.setImageResource(R.drawable.dice_1)
          2 -> diceImage.setImageResource(R.drawable.dice_2)
          3 -> diceImage.setImageResource(R.drawable.dice_3)
          4 -> diceImage.setImageResource(R.drawable.dice_4)
          5 -> diceImage.setImageResource(R.drawable.dice_5)
          6 -> diceImage.setImageResource(R.drawable.dice_6)
      }

        diceImage.contentDescription = diceRoll.toString()


    }


}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}