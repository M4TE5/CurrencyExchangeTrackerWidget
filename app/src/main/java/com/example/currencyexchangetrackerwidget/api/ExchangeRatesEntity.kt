package com.example.currencyexchangetrackerwidget.api

data class ExchangeRatesEntity(
    val rates: List<ExchangeRateEntity>
)

data class ExchangeRateEntity(
    val rate: Double,
    val iso: String,
    val quantity: Int,
    val date: String,
    val name: String
)
