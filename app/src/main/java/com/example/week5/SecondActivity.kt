package com.example.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

/**
 * second activity that displays where i display the information collected from my first
 * activity (the registration page)
 */
class SecondActivity : AppCompatActivity() {

//    initializing variables that would be used later in the code
    lateinit var username1: TextView
    lateinit var email1: TextView
    lateinit var phoneNumber1: TextView
    lateinit var gender1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        referencing the id of my views
        username1 = findViewById(R.id.name1)
        email1 = findViewById(R.id.email1)
        phoneNumber1 = findViewById(R.id.phone1)
        gender1 = findViewById(R.id.gender1)

//        i use this val to receieve the data gotten from main activity
        val name = intent.getStringExtra("username")
        val phone = intent.getStringExtra("phoneNumber")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")

//        i assign value to the data gotten
        username1.text = name
        phoneNumber1.text = phone
        email1.text = email
        gender1.text = gender
    }
}