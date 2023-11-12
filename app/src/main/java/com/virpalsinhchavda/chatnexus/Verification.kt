package com.virpalsinhchavda.chatnexus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        // Reference the button
        val backArrowButton: Button = findViewById(R.id.backarrowbutton)

        // Set a click listener for the button
        backArrowButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            fun navigateToSecondActivity(view: View) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
