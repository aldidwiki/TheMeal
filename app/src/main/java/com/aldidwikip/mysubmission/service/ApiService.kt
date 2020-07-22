package com.aldidwikip.mysubmission.service

import com.aldidwikip.mysubmission.model.DetailMealModel
import com.aldidwikip.mysubmission.model.MealModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET("filter.php")
    fun getMeals(@Query("a") area: String): Call<MealModel>

    @GET("lookup.php")
    fun getMealDetail(@Query("i") iDMeal: String): Call<DetailMealModel>

    companion object {
        private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

        fun create(): ApiService {
            val httpClient = OkHttpClient.Builder().apply {
                connectTimeout(20, TimeUnit.SECONDS)
                readTimeout(20, TimeUnit.SECONDS)
            }.build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}