package com.virpalsinhchavda.chatnexus

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberEditText: EditText = findViewById(R.id.editTextnumber)
        val myButton: Button = findViewById(R.id.buttonContinue)

        // Set the initial background color
        myButton.setBackgroundColor(Color.parseColor("#FFDDCF51"))

        // Set a click listener for the button
        myButton.setOnClickListener {
            // Get the phone number from the EditText
            val phoneNumber = numberEditText.text.toString()

            // Check if the phone number is not empty
            if (phoneNumber.isNotEmpty()) {
                // If not empty, navigate to the Verification activity
                navigateToVerificationActivity()
            } else {
                // If empty, display an error message
                Toast.makeText(this, "Please enter your number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to navigate to the Verification activity
    private fun navigateToVerificationActivity() {
        val intent = Intent(this, Verification::class.java)
        startActivity(intent)
    }
}
