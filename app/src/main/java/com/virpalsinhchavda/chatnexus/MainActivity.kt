package com.virpalsinhchavda.chatnexus

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NumberEditText: EditText = findViewById(R.id.editTextnumber)
        val myButton: Button = findViewById(R.id.buttonContinue)

        // Set the initial background color
        myButton.setBackgroundColor(Color.parseColor("#FFDDCF51"))

        // Set a click listener for the button
        myButton.setOnClickListener {
            val inputText = NumberEditText.text.toString()

            if (inputText.length == 10) {
                // If the input length is equal to 10, navigate to the next activity
                navigateToVerificationActivity()
            } else {
                // If the input length is less than 10, show an error message
                NumberEditText.error = "Minimum length is 10 characters"
            }
        }
    }

    // Function to navigate to the Verification activity
    private fun navigateToVerificationActivity() {
        val intent = Intent(this, Verification::class.java)
        startActivity(intent)
    }
}
