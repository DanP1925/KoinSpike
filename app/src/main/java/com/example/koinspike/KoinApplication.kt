package com.example.koinspike

import android.app.Application
import com.example.koinspike.di.mainModule
import org.koin.core.context.startKoin

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(mainModule)
        }
    }
}