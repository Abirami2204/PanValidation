package com.example.panvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPan = findViewById<EditText>(R.id.etPan)
        val etPincode = findViewById<EditText>(R.id.etPincode)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnValidate.setOnClickListener {

            val pan = etPan.text.toString().trim()
            val pincode = etPincode.text.toString().trim()

            // i) Both fields should not be empty
            if (pan.isEmpty() || pincode.isEmpty()) {
                Toast.makeText(this, "Both fields must not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ii) PAN Card Number - alphanumeric only, exactly 10 characters
            val panPattern = Regex("^[A-Za-z0-9]{10}$")
            if (!pan.matches(panPattern)) {
                Toast.makeText(this, "PAN must be 10 alphanumeric characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // iii) Pincode - numeric only, exactly 6 digits
            val pincodePattern = Regex("^\\d{6}$")
            if (!pincode.matches(pincodePattern)) {
                Toast.makeText(this, "Pincode must be exactly 6 digits", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Validation Successful!", Toast.LENGTH_LONG).show()
        }
    }
}