package hu.paulolajos.data.network

/**
 * For webservices we need the end point for fetching the data from api service, for this we will
 * create the interface class in package network → ApiEndPoint.kt we will be using the following
 * base url https://api.github.com/ to get gitHub Repository profile data.
 */

import hu.paulolajos.data.model.GithubResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoint {
    @GET("search/repositories")
    fun getAllRepo(@Query("q") q : String) : Call<GithubResponseModel>
}