package com.example.recycler_view_countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinexamples.PaisesLatam
import com.example.recycler_view_countries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countryAdapter = CountryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initAdapter()
        setContentView(binding.root)


    }

    fun initAdapter() {
        countryAdapter.setCountryList(PaisesLatam.paises)
        binding.recyclerView.adapter = countryAdapter
    }
}