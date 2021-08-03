package com.example.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var username1: TextView
    lateinit var email1: TextView
    lateinit var phoneNumber1: TextView
    lateinit var gender1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        username1 = findViewById(R.id.name1)
        email1 = findViewById(R.id.email1)
        phoneNumber1 = findViewById(R.id.phone1)
        gender1 = findViewById(R.id.gender1)

        var name = intent.getStringExtra("username")
        var phone = intent.getStringExtra("phoneNumber")
        var email = intent.getStringExtra("email")
        var gender = intent.getStringExtra("gender")

        username1.text = name
        phoneNumber1.text = phone
        email1.text = email
        gender1.text = gender
    }
}