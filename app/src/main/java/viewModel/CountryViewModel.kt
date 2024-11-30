package viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.Country

class CountryViewModel : ViewModel() {
    val countryLiveData = MutableLiveData<Country>()


    fun getDataFromRoom()
    {
        val country = Country("Turkey", "Europe", "Ankara", "TL", "Turkish", "www")

        countryLiveData.value = country

    }

}