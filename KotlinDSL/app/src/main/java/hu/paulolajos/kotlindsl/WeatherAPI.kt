package hu.paulolajos.kotlindsl

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET(
        "data/2.5/weather"
    )

    fun getWeather(
        @Query("q") q: String = "Békéscsaba,hu",
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = "dbbfc0182e36f26e2c37714258f1fb8d"
    ) : Call<WeatherResult>
}