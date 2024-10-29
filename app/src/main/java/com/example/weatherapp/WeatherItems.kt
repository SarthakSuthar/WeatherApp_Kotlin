package com.example.weatherapp

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("weather")
    val weatherItems: List<WeatherItem>,

    @SerializedName("main")
    val mainInfo: MainInfo
)

data class WeatherItem(
    @SerializedName("id")
    val id: Int,

    @SerializedName("main")
    val main: String
)

data class MainInfo(
    @SerializedName("temp")
    val temp: Double
)
