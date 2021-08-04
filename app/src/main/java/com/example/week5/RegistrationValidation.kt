package com.example.week5

import android.util.Patterns

object RegistrationValidation {
    /**
     * the input is not valid if ...
     * 1. the username is empty
     * 2. the email is empty
     * 3. the phone number is empty
     * 4. if the name is not first name and last
     * 5. if if the name contains numbers
     * 6. if the name contains special characters
     * 7. if the name is less than 3 characters
     * 8. if the email is not of email format
     * 9. if the phone number does not start with zero or start with +234
     * 10. if the lenght of the phone number is not either 11 or 13
     */

    fun validateName(name:String):Boolean{
        val namePattern = Regex("(^[A-Za-z]+\\s[A-Za-z]+$)")

        if (namePattern.matches(name)){
            return true
        }
        return false
    }

    fun validatesEmail(email:String):Boolean{
        val sortedEmail = email.split(".")
        val lastIndex = sortedEmail[sortedEmail.size-1]
        if (email.any { it in "@" } && email.any { it in "." } && (lastIndex=="com"|| lastIndex =="dev")){
            return true
        }
        return false
    }


    fun validatePhoneNumber(numbers:String):Boolean{

      val numformat = Regex("([+\\d]234)[0-9]{10}|[0][0-9]{10}")
        if (numformat.matches(numbers)){
            return true
        }
        return false
    }
}