package ru.sberinvestor

import android.os.Build
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
//import org.robolectric.annotation.Config
//import org.robolectric.pluginapi.Sdk
import ru.sberinvestor.dashboard.DashboardFragment

@RunWith(AndroidJUnit4::class)
//@Config(sdk = [Build.VERSION_CODES.P])
class DashboardSuite{
    @Test
    fun testEventFragment() {
        val scenario = launchFragmentInContainer<DashboardFragment>()
        scenario.recreate()
    }
}