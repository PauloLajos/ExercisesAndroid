package hu.paulolajos.data.model

/**
 * For the web service API values we also need data class to hold the values,
 * Let’s create the model class in package data → model →
 */
data class GithubResponseModel(val items: ArrayList<MyData>)

data class MyData(val name: String, val description: String, val created_at: String, val owner: Owner)

data class Owner(val avatar_url: String)