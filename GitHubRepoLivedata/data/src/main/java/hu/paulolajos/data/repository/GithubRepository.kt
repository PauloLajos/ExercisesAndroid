package hu.paulolajos.data.repository

/**
 * For clean architecture we need repository class, we will create GithubRepository.kt class in
 * package data, repository is used to abstract the data layer, and later we will be integrating
 * the repository class to the ViewModel .
 */

import hu.paulolajos.data.network.ApiEndPoint
import hu.paulolajos.data.network.RetrofitClient

class GithubRepository {
    private val retrofit = RetrofitClient.getRetrofitInstance().create(ApiEndPoint::class.java)

    fun getAllRepository(query : String) = retrofit.getAllRepo(query)
}