package com.example.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
//    declaring variables that will be used later in the code
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var username: EditText
    lateinit var email: EditText
    lateinit var phoneNumber: EditText
    lateinit var submit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//  setting up my dropdown gender selection using auto completeCompleteText method
        var choice = arrayOf("male", "female")
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down, choice)
        autoCompleteTextView.setAdapter(arrayAdapter)

//        assigning values to my variables
        username = findViewById(R.id.username)
        email = findViewById(R.id.email)
        phoneNumber = findViewById(R.id.phone_number)
        submit = findViewById(R.id.submit)

        /**
         * collecting my input from user, converts them to Strings and pass them
         * to the next activity using intent.
         * this is done by setting onClickListener on my button named "submit"
         * i also included some conditions that must be met before the setOnclickListener can be triggered
         */

        submit.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("username", username.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("phoneNumber", phoneNumber.text.toString())
            intent.putExtra("gender", autoCompleteTextView.text.toString())

//   i use the .trim() to trim the remove white spaces
            val name = username.text.toString().trim()
            val mail = email.text.toString().trim()
            val number = phoneNumber.text.toString().trim()
            val sex = autoCompleteTextView.text.toString().trim()

            /** to pass registrations, it must pass some certain conditions stated in the
             * you can click on the functions to see the requirements
             * if the format is not entered correctly, it throws an error message and prompt you to enter again
             * same applies to other fields like
             *
             */

            if (RegistrationValidation.validateName(name)
                && RegistrationValidation.validateEmail(mail)
                && RegistrationValidation.validatePhoneNumber(number)){
                startActivity(intent)
            }
            else {
                if (!RegistrationValidation.validateName(name)) {
                    username.error = "please Enter First and Last Name only"
                    return@setOnClickListener
                }
                if (!RegistrationValidation.validateEmail(mail)) {
                    email.error= " enter a valid email"
                    return@setOnClickListener
                }
                if (!RegistrationValidation.validatePhoneNumber(number)) {
                phoneNumber.error = " enter a number format either local or int'l format"
                return@setOnClickListener
                 }

            }

        }

    }

}














//if (!RegistrationValidation.validateGender(sex)){
//    autoCompleteTextView.error = "please chose gender"
//    return@setOnClickListener
//}


//            if (!RegistrationValidation.validateName(name)) {
//                username.error = "please Enter First and Last Name only"
//                return@setOnClickListener
//
//            }
//            if (!RegistrationValidation.validateEmail(mail)) {
//                email.error = "invalid email format"
//                return@setOnClickListener
//            }
//            if (!RegistrationValidation.validatePhoneNumber(number)) {
//                phoneNumber.error = " enter a number format either local or int'l format"
//                return@setOnClickListener
//            }
//
//            else {
//                startActivity(intent)
//            }