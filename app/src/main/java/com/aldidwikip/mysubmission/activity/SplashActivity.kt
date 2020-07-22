package com.aldidwikip.mysubmission.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.aldidwikip.mysubmission.R
import com.aldidwikip.mysubmission.presenter.SplashPresenter
import com.aldidwikip.mysubmission.view.SplashView

class SplashActivity : AppCompatActivity(), SplashView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val presenter = SplashPresenter(this)

        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions

        presenter.loadSplash()
    }

    override fun showSplashScreen(duration: Long) {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, duration)
    }
}