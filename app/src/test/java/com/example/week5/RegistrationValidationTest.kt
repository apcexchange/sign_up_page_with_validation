package com.example.week5



import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class RegistrationValidationTest{

//    test to confirm the validation of my registration functions

    @Test
    fun empty_Username_should_return_false(){
        val result = ""
        assertTrue(RegistrationValidation.validateName(result))
    }

    @Test
    fun invalid_email_format_should_return_false(){
        val email = "@acuuytbcgmail.de"
        assertTrue(RegistrationValidation.validatesEmail(email))
    }

    @Test
    fun invalid_phone_numberFormat_should_return_false(){
        val phoneNumber = "+2348164955123"
        assertTrue(RegistrationValidation.validatePhoneNumber(phoneNumber))
    }
}