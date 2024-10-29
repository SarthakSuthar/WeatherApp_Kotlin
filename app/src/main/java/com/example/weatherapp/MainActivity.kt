package com.example.weatherapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var weatherService: WeatherService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var tempText = findViewById<TextView>(R.id.textTemp)

        val apiKey = "d69cea8b83ec4b972bf6616a72a2ef5c"

        RetrofitInstance.api.getWeather(22.3072, 73.1812, apiKey).enqueue(object : retrofit2.Callback<WeatherResponse>{
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful){
                    val weatherBody = response.body()
                    val temperature = weatherBody?.mainInfo?.temp
                    val mainWeather = weatherBody?.weatherItems?.get(0)?.main

                    tempText.text = temperature.toString()
                }
                else{
                    tempText.text = "Failed to fetch data"
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                tempText.text = "Failed to fetch data"
            }

        })
    }

}