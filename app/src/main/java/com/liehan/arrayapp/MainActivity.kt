package com.liehan.arrayapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val numbers = IntArray(10) // Array to store numbers (size 10)
    private var counter = 0 // Counter for button presses

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Make sure this layout file exists

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val textViewCounter = findViewById<TextView>(R.id.textViewCounter)
        val textViewNumbers = findViewById<TextView>(R.id.textViewNumbers)

        buttonAdd.setOnClickListener {
            val numberString = editTextNumber.text.toString()
            if (numberString.isNotEmpty()) { // Check if the EditText is not empty
                try {
                    val number = numberString.toInt()
                    if (counter < 10) {
                        numbers[counter] = number // Add the number to the array
                        counter++ // Increment the counter
                        textViewCounter.text = "Counter: $counter" // Update the counter TextView
                        updateNumbersTextView(textViewNumbers) // Update the displayed numbers
                        editTextNumber.text.clear() // Clear the EditText
                    } else {
                        Toast.makeText(this, "Array is full (max 10)", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Invalid input: Please enter a number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            }
        } // end of setOnClickListener
        // Initial counter display
        textViewCounter.text = "Counter: $counter"
    } // end of onCreate

    private fun updateNumbersTextView(textView: TextView) {
        val numbersString = numbers.sliceArray(0 until counter).joinToString(", ") //get the current numbers and format them into a string.
        textView.text = "Numbers: [$numbersString]" //Update the textview with the formatted string.
    }
}