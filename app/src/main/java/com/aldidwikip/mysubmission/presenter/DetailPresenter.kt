package com.aldidwikip.mysubmission.presenter

import android.util.Log
import android.widget.Toast
import com.aldidwikip.mysubmission.TheMeal
import com.aldidwikip.mysubmission.model.DataDetailMealModel
import com.aldidwikip.mysubmission.model.DetailMealModel
import com.aldidwikip.mysubmission.service.ApiService
import com.aldidwikip.mysubmission.view.DetailView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(private val view: DetailView) {
    private val apiService = ApiService.create()
    private val listIngredient: MutableList<String> = mutableListOf()
    private val listMeasure: MutableList<String> = mutableListOf()

    fun loadMealDetail(idMeal: String) {
        val detailMealCall = apiService.getMealDetail(idMeal)
        detailMealCall.enqueue(object : Callback<DetailMealModel> {
            override fun onFailure(call: Call<DetailMealModel>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
                Toast.makeText(TheMeal.context, "Connection Error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<DetailMealModel>, response: Response<DetailMealModel>) {
                view.hideLoading()
                addIngredients(response.body()?.meals!!)
                view.showData(response.body()?.meals!!, listIngredient, listMeasure)
            }
        })
    }

    private fun addIngredients(data: List<DataDetailMealModel>) {
        listIngredient.add(data[0].strIngredient1)
        listIngredient.add(data[0].strIngredient2)
        listIngredient.add(data[0].strIngredient3)
        listIngredient.add(data[0].strIngredient4)
        listIngredient.add(data[0].strIngredient5)
        listIngredient.add(data[0].strIngredient6)
        listIngredient.add(data[0].strIngredient7)
        listIngredient.add(data[0].strIngredient8)
        listIngredient.add(data[0].strIngredient9)
        listIngredient.add(data[0].strIngredient10)
        listIngredient.add(data[0].strIngredient11)
        listIngredient.add(data[0].strIngredient12)
        listIngredient.add(data[0].strIngredient13)
        listIngredient.add(data[0].strIngredient14)
        listIngredient.add(data[0].strIngredient15)
        listIngredient.add(data[0].strIngredient16)
        listIngredient.add(data[0].strIngredient17)
        listIngredient.add(data[0].strIngredient18)
        listIngredient.add(data[0].strIngredient19)
        listIngredient.add(data[0].strIngredient20)

        listMeasure.add(data[0].strMeasure1)
        listMeasure.add(data[0].strMeasure2)
        listMeasure.add(data[0].strMeasure3)
        listMeasure.add(data[0].strMeasure4)
        listMeasure.add(data[0].strMeasure5)
        listMeasure.add(data[0].strMeasure6)
        listMeasure.add(data[0].strMeasure7)
        listMeasure.add(data[0].strMeasure8)
        listMeasure.add(data[0].strMeasure9)
        listMeasure.add(data[0].strMeasure10)
        listMeasure.add(data[0].strMeasure11)
        listMeasure.add(data[0].strMeasure12)
        listMeasure.add(data[0].strMeasure13)
        listMeasure.add(data[0].strMeasure14)
        listMeasure.add(data[0].strMeasure15)
        listMeasure.add(data[0].strMeasure16)
        listMeasure.add(data[0].strMeasure17)
        listMeasure.add(data[0].strMeasure18)
        listMeasure.add(data[0].strMeasure19)
        listMeasure.add(data[0].strMeasure20)
    }

    companion object {
        private const val TAG = "DetailPresenter"
    }

}