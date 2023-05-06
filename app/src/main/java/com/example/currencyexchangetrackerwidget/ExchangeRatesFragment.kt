package com.example.currencyexchangetrackerwidget

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyexchangetrackerwidget.api.ApiExchangeRatesDataSource
import com.example.currencyexchangetrackerwidget.databinding.FragmentExchangeRatesBinding

class ExchangeRatesFragment : Fragment() {

    lateinit var binding: FragmentExchangeRatesBinding
    private lateinit var viewModel: ExchangeRatesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exchange_rates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExchangeRatesBinding.bind(view)
        viewModel = ExchangeRatesViewModel()

        viewModel.loadData()
        viewModel.exchangeRates.observe(viewLifecycleOwner){
            binding.textView.text = it.toString()
        }
    }
}