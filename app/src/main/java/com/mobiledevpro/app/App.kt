package com.mobiledevpro.app

import android.app.Application
import com.mobiledevpro.app.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Main application class
 *
 * Created by Dmitriy Chernysh
 *
 *
 * http://androiddev.pro
 *
 *
 * #MobileDevPro
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(getModules())
        }
    }

    private fun getModules() = listOf(
            uiModule,
            domainModule,
            dataModule,
            dataLocalModule,
            dataRemoteModule
    )
}
