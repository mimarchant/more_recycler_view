package com.example.recycler_view_countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinexamples.PaisesLatam
import com.example.recycler_view_countries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CountryCallback {
    private lateinit var binding: ActivityMainBinding
    val countryAdapter = CountryAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initAdapter()
        setContentView(binding.root)


    }

    fun initAdapter() {
        countryAdapter.getCountryList(PaisesLatam.paises)
        countryAdapter.setCountryCallback(this)
        binding.recyclerView.adapter = countryAdapter

    }

    override fun showCountry(s: String) {
        binding.mainTitle.text = s
    }
}