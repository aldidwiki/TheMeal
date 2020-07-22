package com.aldidwikip.mysubmission.view

import com.aldidwikip.mysubmission.model.DataMealModel

interface MainView {
    fun showConnectionError()
    fun hideConnectionError()
    fun showLoading()
    fun hideLoading()
    fun onDataLoaded(list: List<DataMealModel>)
}