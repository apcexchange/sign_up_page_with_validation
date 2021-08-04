package com.example.week5


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndToEndTest {

    lateinit var textName: String
    lateinit var textEmail: String
    lateinit var textPhone: String
    lateinit var textGender: String

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        textName = "Country Nigeria"
        textEmail = "peter@gmail.com"
        textPhone = "08164955123"
        textGender = "male"
    }

    @Test
    fun check_username_is_visible() {
        onView(withId(R.id.username)).check(matches(isDisplayed()))
    }

    @Test
    fun check_email_is_visible() {
        onView(withId(R.id.email)).check(matches(isDisplayed()))
    }

    @Test
    fun check_phoneNumber_is_visible() {
        onView(withId(R.id.phone_number)).check(matches(isDisplayed()))
    }

    @Test
    fun check_if_mainLayout_is_visible() {
        onView(withId(R.id.main_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun check_if_button_send_data_to_second_activity() {

        onView(withId(R.id.username)).perform(typeText(textName), closeSoftKeyboard())
        onView(withId(R.id.email)).perform(typeText(textEmail), closeSoftKeyboard())
        onView(withId(R.id.phone_number)).perform(typeText(textPhone), closeSoftKeyboard())
        onView(withId(R.id.autoCompleteTextView)).perform(click())
        onView(withText(textGender)).inRoot(RootMatchers.isPlatformPopup()).perform(click())


        onView(withId(R.id.submit)).perform(click())
        onView(withId(R.id.name1)).check(matches(withText(textName)))
        onView(withId(R.id.email1)).check(matches(withText(textEmail)))
        onView(withId(R.id.phone1)).check(matches(withText(textPhone)))
        onView(withId(R.id.gender1)).check(matches(withText(textGender)))
    }
}