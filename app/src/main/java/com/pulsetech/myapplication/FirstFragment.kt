package com.pulsetech.myapplication

import adapter.countryAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import viewModel.FeedViewModel


class FirstFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private lateinit var countryAdapter: countryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)


        val countryList = view.findViewById<RecyclerView>(R.id.countryList)
        countryAdapter = countryAdapter(arrayListOf())
        countryList.adapter = countryAdapter
        countryList.layoutManager = LinearLayoutManager(context)

        observeLiveData()
        val swipeRefreshLayout = view.findViewById<androidx.swiperefreshlayout.widget.SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            countryList.visibility = View.GONE
            view.findViewById<TextView>(R.id.errorText).visibility = View.GONE
            view.findViewById<ProgressBar>(R.id.countryLoading).visibility = View.VISIBLE
            viewModel.refreshData()
            swipeRefreshLayout.isRefreshing = false
        }

        return view
    }

    private fun observeLiveData() {


        viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->
            countries?.let {
                countryAdapter.updateCountryList(countries)
                view?.findViewById<ProgressBar>(R.id.countryLoading)?.visibility = View.GONE
                view?.findViewById<RecyclerView>(R.id.countryList)?.visibility = View.VISIBLE
            }
        })


        viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                val errorText = view?.findViewById<TextView>(R.id.errorText)
                if (it) {
                    errorText?.visibility = View.VISIBLE
                } else {
                    errorText?.visibility = View.GONE
                }
            }
        })
    }
}









