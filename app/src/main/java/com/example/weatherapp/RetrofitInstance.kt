package com.example.weatherapp

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private const val MAIN_URL = "https://api.openweathermap.org/"

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

        val api: WeatherService by lazy {
            retrofit.create(WeatherService::class.java)
        }
    }
}