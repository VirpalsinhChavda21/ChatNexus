package com.virpalsinhchavda.chatnexus

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.Animation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NumberEditText: EditText = findViewById(R.id.editTextnumber)
        val myButton: Button = findViewById(R.id.buttonContinue)
        val iv_logo: ImageView = findViewById(R.id.logo)

        val countryCodeTextView = findViewById<TextView>(R.id.editTextnumber)
        // Set the text programmatically
        // You can customize this text as needed
        countryCodeTextView.text = "Country Code: +91"

        val defaultPrefix = "+91"
        NumberEditText.setText(defaultPrefix)

        // Set the initial background color
        myButton.setBackgroundColor(Color.parseColor("#FFDDCF51"))

        //to animate button when click
        /*myButton.setOnClickListener{
            iv_logo.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction{
                iv_logo.animate().apply {
                    duration = 1000
                    rotationXBy(360f)
                }
            }
        }*/

        // Set a click listener for the button
        myButton.setOnClickListener {
            val inputText = NumberEditText.text.toString()

            if (inputText.length == 13) {
                // If the input length is equal to 10, navigate to the next activity
                navigateToVerificationActivity()
            } else {
                // If the input length is less than 10, show an error message
                NumberEditText.error = "Minimum length of Number is 10 characters"
            }
        }
        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
    }

    // Function to navigate to the Verification activity
    private fun navigateToVerificationActivity() {
        val intent = Intent(this, Verification::class.java)
        startActivity(intent)
    }
}
