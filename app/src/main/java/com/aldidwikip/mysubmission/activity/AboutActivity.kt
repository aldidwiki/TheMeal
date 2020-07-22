package com.aldidwikip.mysubmission.activity

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aldidwikip.mysubmission.R
import kotlinx.android.synthetic.main.activity_about.*
import java.util.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        try {
            val pInfo = packageManager.getPackageInfo(packageName, 0)
            tv_app_version.text = resources.getString(R.string.version_name, pInfo.versionName)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            Log.d("AboutActivity", "PackageManager Catch : $e")
        }

        val year = Calendar.getInstance().get(Calendar.YEAR)
        tv_copyright.text = resources.getString(R.string.copyright, year)
    }
}