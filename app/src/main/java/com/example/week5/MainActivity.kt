package com.example.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var username: EditText
    lateinit var email: EditText
    lateinit var phoneNumber: EditText
    lateinit var submit: Button
//    lateinit var gender: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//  setting up my dropdown gender selection
        var choice = arrayOf("male","female")
        autoCompleteTextView= findViewById(R.id.autoCompleteTextView)
        val arrayAdapter = ArrayAdapter(this,R.layout.drop_down,choice)
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(),false)
        autoCompleteTextView.setAdapter(arrayAdapter)

        username = findViewById(R.id.username)
        email = findViewById(R.id.email)
        phoneNumber = findViewById(R.id.phone_number)
        submit = findViewById(R.id.submit)




        submit.setOnClickListener {
            val intent =Intent(this,SecondActivity::class.java)
            intent.putExtra("username",username.text.toString())
            intent.putExtra("email",email.text.toString())
            intent.putExtra("phoneNumber",phoneNumber.text.toString())
            intent.putExtra("gender",autoCompleteTextView.text.toString())

                val name =username.text.toString().trim()
                val mail =email.text.toString().trim()
                val number =phoneNumber.text.toString().trim()
             val namePattern = Regex("(^[A-Za-z]+\\s[A-Za-z]+$)")
            val internationalOrLocalNumberFormat = Regex("([+\\d]234)[0-9]{10}|[0][0-9]{10}")

            if (!namePattern.matches(name)){
                username.error = "Enter First and Last Name"
                return@setOnClickListener
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                email.error = "invalid email format"
                return@setOnClickListener
            }

            else if (!internationalOrLocalNumberFormat.matches(number)){
                phoneNumber.error = " enter a number format either local or int'l"
                return@setOnClickListener
            }

            else{
                startActivity(intent)
            }

        }

    }

}