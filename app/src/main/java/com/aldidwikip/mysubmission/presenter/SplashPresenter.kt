package com.aldidwikip.mysubmission.presenter

import com.aldidwikip.mysubmission.view.SplashView

class SplashPresenter(val view: SplashView) {

    fun loadSplash() {
        val duration = 1500L
        view.showSplashScreen(duration)
    }

}