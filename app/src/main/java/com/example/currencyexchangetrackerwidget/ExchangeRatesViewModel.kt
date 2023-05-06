package com.example.currencyexchangetrackerwidget

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangetrackerwidget.api.ApiExchangeRatesDataSource
import com.example.currencyexchangetrackerwidget.api.ExchangeRateEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExchangeRatesViewModel: ViewModel() {

    private val _exchangeRates = MutableLiveData<List<ExchangeRateEntity>>()
    val exchangeRates: LiveData<List<ExchangeRateEntity>>
        get() = _exchangeRates

    private val apiDataSource by lazy { ApiExchangeRatesDataSource }

    fun loadData(){
        viewModelScope.launch(Dispatchers.IO){
            val list = apiDataSource.getExchangeRates()
            withContext(Dispatchers.Main){
                _exchangeRates.value = list
            }
        }
    }
}