package com.example.tiptime

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    //This line declares a top-level variable in the class for the binding object.
    // It's defined at this level because it will be used across
    // multiple methods in MainActivity class.

    /*The lateinit keyword is something new.
    It's a promise that your code will initialize the variable before using it.
    If you don't, your app will crash.*/
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This line initializes the binding object which
        // you'll use to access Views in the activity_main.xml layout.
        binding = ActivityMainBinding.inflate(layoutInflater)

        //Set the content view of the activity.
        // Instead of passing the resource ID of the layout, R.layout.activity_main,
        // this specifies the root of the hierarchy of views in your app,
        // binding.root
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        //.text == .getText()
        //convert it to a String
        val stringInTextField = binding.CostServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        if ( cost == null ){
            Toast.makeText(this, "Empty Cost of Service", Toast.LENGTH_LONG).show()
            binding.tipResult.text = ""
            return
        }

        //checkedRadioButtonId attribute of the tipOptions RadioGroup,
        //and assign it to a variable called selectedId
        /*val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }*/

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        //multiply tipPercentage by cost, and assign it to a variable called tip
        var  tip = tipPercentage * cost

        //Assign the isChecked attribute of the round up switch to a variable called roundUp
        val roundUp = binding.roundUpSwitch.isChecked

       /* when(roundUp){
            val tip -> ceil(tip)
        }*/

        //Add an if statement that assigns the
        //ceiling of the tip to the tip variable if roundUp is true.
        if (roundUp){
            tip = ceil(tip)
        }

        NumberFormat.getCurrencyInstance()
        val formatedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formatedTip)
    }
}