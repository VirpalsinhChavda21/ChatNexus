package com.virpalsinhchavda.chatnexus

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker

@Suppress("DEPRECATION")
class Username : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username)

        val myButton: Button = findViewById(R.id.buttonDone)
        val userEditText: EditText = findViewById(R.id.username_input)
        val photoImageView: ImageView = findViewById(R.id.profilePicture)

        myButton.setBackgroundColor(Color.parseColor("#FFDDCF51"))

        myButton.setOnClickListener {
            val inputText = userEditText.text.toString()

            //--------------
            //temporary added animation activity
            //--------------

            if (inputText.isNotEmpty()) {
                navigateToAnimationActivity()
            } else {
                userEditText.error = "Please Enter your Username"
            }
        }

        // Set a click listener for the photo button
        photoImageView.setOnClickListener {
            openGallery()
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        Toast.makeText(this, "You Can't go back , Finish your Sign in first", Toast.LENGTH_SHORT).show()
    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data
            val imgProfile: ImageView = findViewById(R.id.profilePicture)
            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!
                var mProfileUri = fileUri
                imgProfile.setImageURI(fileUri)

            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }


    // Click event handler for the photo button
    private fun openGallery() {

        ImagePicker.with(this)
            .crop()                    //Crop image(Optional), Check Customization for more option
            .compress(1024)            //Final image size will be less than 1 MB(Optional)
            .maxResultSize(
                400,
                400
            )    //Final image resolution will be less than 1080 x 1080(Optional)
            .start()
        ImagePicker.with(this)
            .crop(1f, 1f)    //Crop image with 16:9 aspect ratio
            .start()
    }

    private fun openCamera() {
        ImagePicker.with(this)
            .crop()        //Crop image and let user choose aspect ratio.
            .start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!
            val imgProfile: ImageView = findViewById(R.id.profilePicture)
            val fileUri = data?.data!!

            // Use Uri object instead of File to avoid storage permissions
            imgProfile.setImageURI(fileUri)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToAnimationActivity() {
        val intent = Intent(this, Animation::class.java)
        startActivity(intent)
    }
}