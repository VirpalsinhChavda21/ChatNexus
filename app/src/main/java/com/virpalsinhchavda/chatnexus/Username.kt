package com.virpalsinhchavda.chatnexus

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Username : AppCompatActivity() {
    companion object {
        private const val PICK_IMAGE_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username)

        val myButton: Button = findViewById(R.id.buttonDone)
        val userEditText: EditText = findViewById(R.id.username_input)
        val photoImageView: ImageView = findViewById(R.id.buttonImageView)
        val vectorImageView : ImageView = findViewById(R.id.profileImageView)

        myButton.setBackgroundColor(Color.parseColor("#FFDDCF51"))

        // Set a click listener for the photo button
        photoImageView.setOnClickListener {
            openGallery()
        }
        vectorImageView.setOnClickListener {
            openGallery()
        }
    }

    // Click event handler for the photo button
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE)
    }

    // Handle the result when an image is picked
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // Handle the selected image URI
            val selectedImageUri = data?.data
            if (selectedImageUri != null) {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedImageUri)
                // Update the circular ImageView with the chosen photo
                findViewById<ImageView>(R.id.buttonImageView).setImageBitmap(bitmap)

                // Hide the vector asset ImageView
                findViewById<ImageView>(R.id.profileImageView).visibility = View.GONE
            }
        }
    }
}

