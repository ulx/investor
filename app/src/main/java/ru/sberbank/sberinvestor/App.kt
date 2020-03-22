package ru.sberbank.sberinvestor

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.leakcanary.LeakCanaryFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.sberbank.sberinvestor.di.appModule


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            androidLogger()
            // Android context
            androidContext(this@App)
            // modules
            modules(appModule)
        }
        initFlipper()
    }

    // flipper - пока под сомнением, возможно достаточно студии
    private fun initFlipper() {
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            SoLoader.init(this, false)
            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            val networkFlipperPlugin = NetworkFlipperPlugin()
            client.addPlugin(networkFlipperPlugin);
            client.addPlugin(LeakCanaryFlipperPlugin())
            client.start()
        }
    }
}
