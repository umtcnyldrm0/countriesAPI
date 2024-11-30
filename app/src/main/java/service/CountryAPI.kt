package service

import io.reactivex.rxjava3.core.Single
import model.Country
import retrofit2.http.GET

interface CountryAPI {


    @GET("countrydataset.json")

    fun getCountries(): Single<List<Country>>
}