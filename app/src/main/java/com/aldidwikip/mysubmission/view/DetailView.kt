package com.aldidwikip.mysubmission.view

import com.aldidwikip.mysubmission.model.DataDetailMealModel

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showData(data: List<DataDetailMealModel>, listIngredient: MutableList<String>, listMeasure: MutableList<String>)
}