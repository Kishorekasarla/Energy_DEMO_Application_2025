package com.infmenergy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InfmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}