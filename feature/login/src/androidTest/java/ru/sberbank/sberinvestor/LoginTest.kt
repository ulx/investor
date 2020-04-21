package ru.sberbank.sberinvestor

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    companion object {
        val LOGIN_PACKAGE = "ru.sberbank.sberinvestor.login"
    }

    @get:Rule
    val rule = ActivityScenarioRule(NavHostActivity::class.java)

    @Test
    fun test() {
        onView(withId(getLoginId("loginUnderConstructionTextView"))).check(matches(isDisplayed()))
        onView(withId(getLoginId("loginButton"))).perform(click())
    }

    private fun getLoginId(name: String) = getId(name, LOGIN_PACKAGE)

    private fun getId(name: String, packageName: String): Int {
        return InstrumentationRegistry.getInstrumentation().targetContext.resources.getIdentifier(
            name,
            "id",
            packageName);
    }
}