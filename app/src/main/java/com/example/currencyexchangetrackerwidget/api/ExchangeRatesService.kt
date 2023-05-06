package com.example.currencyexchangetrackerwidget.api

import com.example.currencyexchangetrackerwidget.api.UrlConstants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ExchangeRatesService {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val apiService: ExchangeRatesApi = retrofit.create(ExchangeRatesApi::class.java)
}