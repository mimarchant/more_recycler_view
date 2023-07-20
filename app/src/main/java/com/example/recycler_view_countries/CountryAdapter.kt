package com.example.recycler_view_countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinexamples.Pais
import com.example.recycler_view_countries.databinding.CountryItemBinding

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    var countryList = mutableListOf<Pais>()
    var callback : CountryCallback? = null

    fun setCountryCallback(c: CountryCallback) {
        this.callback = c
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        val country = countryList[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun getCountryList(country: List<Pais>) {
        this.countryList = country.toMutableList()
    }

    inner class ViewHolder(private val binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Pais) {
            binding.countryName.text = country.nombre
            binding.countryPopulation.text = country.poblacion.toString()

            Glide.with(itemView.context)
                .load(country.imgUrl)
                .into(binding.countryImg)

            val text = "Pais: ${country.nombre}\nPoblacion: ${country.poblacion}"
            binding.countryContainer.setOnClickListener(View.OnClickListener {
                callback?.showCountry(text)
            })
        }

        }
    }


 interface CountryCallback {
    fun showCountry(s: String)
}



