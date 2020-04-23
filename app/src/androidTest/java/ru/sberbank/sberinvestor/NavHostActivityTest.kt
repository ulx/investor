package ru.sberbank.sberinvestor

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavHostActivityTest {

    companion object {
        val DASHBOARD_PACKAGE = "ru.sberbank.sberinvestor.dashboard"
        val LOGIN_PACKAGE = "ru.sberbank.sberinvestor.login"
    }

    @get:Rule
    val rule = ActivityScenarioRule(NavHostActivity::class.java)

    @Test
    @Ignore("Не работает запуск инструментального интеграционного теста в app модуле из консоли")
    fun test() {
        onView(withId(getLoginId("loginUnderConstructionTextView"))).check(matches(isDisplayed()))
        onView(withId(getLoginId("loginButton"))).perform(click())

        onView(withId(getDashboardId("button_balance"))).check(matches(withText("Balance")))
        onView(withId(getDashboardId("button_market"))).check(matches(withText("Market")))
        onView(withId(getDashboardId("button_news"))).check(matches(withText("News")))
        onView(withId(getDashboardId("button_profile"))).check(matches(withText("Profile")))
        onView(withId(getDashboardId("dashboardUnderConstructionTextView"))).check(matches(isDisplayed()))

        onView(withId(getDashboardId("button_profile"))).perform(click())

        onView(withId(getDashboardId("profileUnderConstructionTextView"))).check(matches(withText("Under construction profile")))
    }

    private fun getLoginId(name: String) = getId(name, LOGIN_PACKAGE)

    private fun getDashboardId(name: String) = getId(name, DASHBOARD_PACKAGE)

    private fun getId(name: String, packageName: String): Int {
        return InstrumentationRegistry.getInstrumentation().targetContext.resources.getIdentifier(
            name,
            "id",
            packageName);
    }
}