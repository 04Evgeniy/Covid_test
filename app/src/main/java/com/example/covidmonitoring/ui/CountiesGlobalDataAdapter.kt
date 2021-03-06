package com.example.covidmonitoring.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidmonitoring.R
import com.example.covidmonitoring.data.CountryGlobalData
import kotlinx.android.synthetic.main.item_global_coutry_data.view.*

class CountriesGlobalDataAdapter(
    private val countries: List<CountryGlobalData>
) : RecyclerView.Adapter<CountriesGlobalDataAdapter.CountryGlobalDataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryGlobalDataHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_global_coutry_data, parent, false)
        return CountryGlobalDataHolder(view)
    }

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryGlobalDataHolder, position: Int) {
        holder.bind(countries[position])
    }


    class CountryGlobalDataHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(countryGlobalData: CountryGlobalData) = itemView.apply {
            countryName.text = countryGlobalData.country
            countryNewConfirmed.text = resources.getString(R.string.new_confirmed_template).format(countryGlobalData.newConfirmed)
        }
    }
}