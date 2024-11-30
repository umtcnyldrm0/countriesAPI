package com.pulsetech.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import viewModel.CountryViewModel

class SecondFragment : Fragment() {

    private lateinit var viewModel: CountryViewModel
    private var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_second, container, false)


        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom()


        observeLiveData()
        return rootView
    }

    private fun observeLiveData() {
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {

                val countryName = rootView?.findViewById<TextView>(R.id.countryName)
                val countryCapital = rootView?.findViewById<TextView>(R.id.countryCapital)
                val countryRegion = rootView?.findViewById<TextView>(R.id.countryRegion)
                val countryCurrency = rootView?.findViewById<TextView>(R.id.countryCurrency)
                val countryLanguage = rootView?.findViewById<TextView>(R.id.countryLanguage)
                val countryFlagImage = rootView?.findViewById<ImageView>(R.id.countryFlagImage)


                countryName?.text = country.countryName
                countryCapital?.text = country.countryCapital
                countryRegion?.text = country.countryRegion
                countryCurrency?.text = country.countryCurrency
                countryLanguage?.text = country.countryLanguage


                countryFlagImage?.setImageResource(R.drawable.ic_launcher_background)
            }
        })
    }
}
