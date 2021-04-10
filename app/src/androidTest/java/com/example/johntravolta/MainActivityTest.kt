package com.example.johntravolta

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    private val dummyJamKerja = "52"
    private val dummyGaji = "870000"
    private val dummyPengeluaran = "500000"
    private val dummyNabung = "John Bisa Menabung Sebesar 370000"
    private val emptyInput = ""
    private val fieldEmpty = "Field ini tidak boleh kosong"

    @Before
    fun setup(){
        ActivityScenario.launch(MainActivity::class.java)
    }

    //pengecekan untuk total gaji
    @Test
    fun assertGetGaji(){
        onView(withId(R.id.edt_jamKerja)).perform(typeText(dummyJamKerja), closeSoftKeyboard())

        onView(withId(R.id.btn_hitungGaji)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_hitungGaji)).perform(click())

        onView(withId(R.id.tv_result_gaji)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result_gaji)).check(matches(withText(dummyGaji)))
    }

    //pegecekan untuk pengeluaran
    @Test
    fun assertGetNabung(){
        onView(withId(R.id.edt_jamKerja)).perform(typeText(dummyJamKerja), closeSoftKeyboard())

        onView(withId(R.id.btn_hitungGaji)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_hitungGaji)).perform(click())

        onView(withId(R.id.tv_result_gaji)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result_gaji)).check(matches(withText(dummyGaji)))

        onView(withId(R.id.edt_pengeluaran)).perform(typeText(dummyPengeluaran), closeSoftKeyboard())

        onView(withId(R.id.btn_hitungPengeluaran)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_hitungPengeluaran)).perform(click())

        onView(withId(R.id.tv_result_pengeluaran)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result_pengeluaran)).check(matches(withText(dummyNabung)))
    }

    //pengecekan untuk empty input
    @Test
    fun assertEmptyInput(){

        //pengecekan input untuk jam kerja
        onView(withId(R.id.edt_jamKerja)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btn_hitungGaji)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_hitungGaji)).perform(click())

        onView(withId(R.id.edt_jamKerja)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.edt_jamKerja)).perform(typeText(dummyGaji), closeSoftKeyboard())

        //pengecekan input untuk pengeluaran
        onView(withId(R.id.edt_pengeluaran)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btn_hitungPengeluaran)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_hitungPengeluaran)).perform(click())

        onView(withId(R.id.edt_pengeluaran)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.edt_pengeluaran)).perform(typeText(dummyPengeluaran), closeSoftKeyboard())

        onView(withId(R.id.btn_hitungPengeluaran)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_hitungPengeluaran)).perform(click())
    }
}