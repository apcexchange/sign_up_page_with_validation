package com.example.week5

object RegistrationValidation {
    /**
     * the input is valid if ...
     * 1. the username is not empty
     * 2. you must enter first and last name
     * 3. name must not contain numbers or special character
     *
     * the email is valid if
     * 1. the email is not empty
     * 2. the email starts with alphabets or special characters
     * 3. the email must contain the '@' symbol followed by another set of alphabets before the '.'
     *    sign and another set of phrase that are defined here.
     *
     *    phone number is valid if
     * 1. the phone number is not empty
     * 2. if the phone number start with '08',09,07, and its length is not more than 11
     * 3. if the number start with +234 and its length its not more than 14
     */

//    function to validate full name
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
        if (email.any { it in "@" } && email.any { it in "." } && (lastIndex=="com"|| lastIndex =="dev"|| lastIndex=="uk"|| lastIndex=="gov")){
            return true
        }
        return false
    }


    fun validatePhoneNumber(numbers:String):Boolean{

      val numFormat = Regex("([+\\d]2347)[0-9]{9}|([+\\d]2348)[0-9]{9}|([+\\d]2349)[0-9]{9}|(09)[0-9]{9}|(08)[0-9]{9}|(07)[0-9][9]")
        if (numFormat.matches(numbers)){
            return true
        }
        return false
    }
}