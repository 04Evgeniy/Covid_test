package com.example.covidmonitoring.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covidmonitoring.R
import com.example.covidmonitoring.data.CovidRepository
import kotlinx.android.synthetic.main.fragment_global.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GlobalFragment : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_global, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = CovidRepository()

        launch {
            val summary = repository.getSummary().await()

            loader.visibility = View.GONE
            globalData.visibility = View.VISIBLE

            summary?.let {

                it.global.let {
                    newConfirmed.text = "New confirmed: %d".format(it.newConfirmed)
                    newDeaths.text = "New deaths: %d".format(it.newDeaths)
                    newRecovered.text = "New recovered: %d".format(it.newRecovered)
                    totalConfirmed.text = "Total counfirmed: %d".format(it.totalConfirmed)
                }

                countriesList.adapter = CountriesGlobalDataAdapter(it.countries)
            }
        }
    }
}