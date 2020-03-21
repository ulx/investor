package ru.sberbank.sberinvestor

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.sberbank.sberinvestor.di.appModule

class App : Application() {
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            androidLogger()
            // Android context
            androidContext(this@App)
            // modules
             modules(appModule)
        }
    }
}