package com.ecommerce.practiceproject.view

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ecommerce.practiceproject.R

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentTwoTest {

    private lateinit var scenario: FragmentScenario<FragmentTwo>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer()
        scenario.moveToState(Lifecycle.State.CREATED)
    }

    @Test
    fun addUser()
    {
        val name = "Atik Faysal"
        val email = "atik@gmail.com"
        val phone = "01647544954"
        val address = "Dhaka, Shukrabad"
        onView(withId(R.id.et_full_name)).perform(typeText(name))
        onView(withId(R.id.et_address)).perform(typeText(address))
        onView(withId(R.id.et_email)).perform(typeText(email))
        onView(withId(R.id.et_phone)).perform(typeText(phone))
        Espresso.closeSoftKeyboard()
        //onView(withId(R.id.btn_save)).perform(click())
    }

}