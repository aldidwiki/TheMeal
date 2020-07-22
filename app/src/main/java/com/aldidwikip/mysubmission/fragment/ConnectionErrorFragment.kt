package com.aldidwikip.mysubmission.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aldidwikip.mysubmission.R
import com.aldidwikip.mysubmission.presenter.MainPresenter
import kotlinx.android.synthetic.main.connection_error.*

class ConnectionErrorFragment(private val presenter: MainPresenter) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.connection_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_retry.setOnClickListener {
            btn_retry.startAnimation()
            presenter.loadMeals()
        }
    }

    override fun onDestroy() {
        btn_retry?.dispose()
        super.onDestroy()
    }
}