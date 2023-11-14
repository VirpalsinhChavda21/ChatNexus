package com.virpalsinhchavda.chatnexus

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class Username : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username)

        val myButton: Button = findViewById(R.id.buttonDone)
        val userEditText: EditText = findViewById(R.id.username_input)

        myButton.setBackgroundColor(Color.parseColor("#FFDDCF51"))

    }
}
