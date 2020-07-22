package com.aldidwikip.mysubmission.presenter

import android.util.Log
import com.aldidwikip.mysubmission.model.DataMealModel
import com.aldidwikip.mysubmission.model.MealModel
import com.aldidwikip.mysubmission.service.ApiService
import com.aldidwikip.mysubmission.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainView) {
    private var list: List<DataMealModel> = listOf()
    private val apiService = ApiService.create()

    fun loadMeals() {
        view.showLoading()

        val mealCall = apiService.getMeals("canadian")
        mealCall.enqueue(object : Callback<MealModel> {
            override fun onFailure(call: Call<MealModel>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
                view.showConnectionError()
            }

            override fun onResponse(call: Call<MealModel>, response: Response<MealModel>) {
                Log.d(TAG, "onResponse: Data Rows = ${response.body()?.meals?.size}")
                view.hideConnectionError()
                view.hideLoading()

                list = response.body()?.meals!!
                view.onDataLoaded(list)
            }
        })
    }

    companion object {
        private const val TAG = "MainPresenter"
    }

}