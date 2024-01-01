package hu.paulolajos.data.network

/**
 * Now we need the retrofit client for HTTP request and add the baseUrl in package
 * network → RetrofitClient.kt.
 *
 * In the below code we added the baseUrl,
 * a converter to convert Json to Kotlin data class or vice versa.
 */

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        private const val baseUrl = "https://api.github.com/"

        fun getRetrofitInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}