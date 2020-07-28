package com.aldidwikip.mysubmission

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class TheMeal : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}