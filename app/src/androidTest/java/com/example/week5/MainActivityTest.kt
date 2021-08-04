package com.example.week5

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule

class MainActivityTest{
    lateinit var text:String

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
}