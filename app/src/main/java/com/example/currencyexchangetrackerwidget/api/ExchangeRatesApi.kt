package com.example.currencyexchangetrackerwidget.api

import com.example.currencyexchangetrackerwidget.api.UrlConstants.CURRENCY_CODE
import retrofit2.http.GET

interface ExchangeRatesApi {

    @GET(CURRENCY_CODE)
    suspend fun getExchangeRates(): ExchangeRatesEntity
}