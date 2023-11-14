package com.virpalsinhchavda.chatnexus

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity

class Verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        // Reference the button
        val backArrowButton: Button = findViewById(R.id.backarrowbutton)
        val otpEditText: EditText = findViewById(R.id.code_input)
        val myButton: Button = findViewById(R.id.continue_button)
        val resendOtpTextView: TextView = findViewById(R.id.resendotp)

        myButton.setBackgroundColor(Color.parseColor("#FFDDCF51"))

        myButton.setOnClickListener {
            // Get the phone number from the EditText
            val phoneNumber = otpEditText.text.toString()

            // Check if the phone number is not empty
            if (phoneNumber.isNotEmpty()) {
                // If not empty, navigate to the Verification activity
                navigateToUsernameActivity()
            } else {
                // If empty, display an error message
                Toast.makeText(this, "Please 6-Digit OTP code", Toast.LENGTH_SHORT).show()
            }
        }

        // Set a click listener for the button
        backArrowButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Set a click listener for the resendOtpTextView
        resendOtpTextView.setOnClickListener {
            showResendOtp()
        }
    }
    private fun showResendOtp() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Resend OTP")
        builder.setMessage("Code will be sent again to your number.")
        builder.setPositiveButton("OK") { _, _ ->
            // Implement the logic to resend OTP here
            // You may call a function to resend OTP or perform the necessary action
            Toast.makeText(this, "Resending OTP...", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun navigateToUsernameActivity() {
        val intent = Intent(this, Verification::class.java)
        startActivity(intent)
    }
}
