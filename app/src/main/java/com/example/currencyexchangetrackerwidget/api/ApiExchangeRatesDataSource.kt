package com.example.currencyexchangetrackerwidget.api

object ApiExchangeRatesDataSource {

    private val api = ExchangeRatesService.apiService

    suspend fun getExchangeRates(): List<ExchangeRateEntity>{
        return api.getExchangeRates().rates
    }
}