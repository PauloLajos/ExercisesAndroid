package hu.paulolajos.ui

/**
 * The next step is about viewModel, we will add our ViewModel class in package
 * viewmodel → MainViewModel.kt.
 *
 * Why we use ViewModel?
 *
 * The ViewModel class is for holding and managing UI-related data in a life-cycle conscious way.
 * This allows data to survive configuration changes such as screen rotations.
 * ViewModels separate UI implementation from your app’s data.
 */

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hu.paulolajos.data.model.GithubResponseModel
import hu.paulolajos.data.model.MyData
import hu.paulolajos.data.network.ApiEndPoint
import hu.paulolajos.data.network.RetrofitClient
import hu.paulolajos.data.repository.GithubRepository
import hu.paulolajos.ui.adapter.DataAdapter
import retrofit2.Call
import retrofit2.Response

class MainViewModel(private val repository: GithubRepository) : ViewModel() {

    private val _githubResponseData = MutableLiveData<GithubResponseModel?>()
    val githubResponseData: MutableLiveData<GithubResponseModel?> = _githubResponseData

    private var dataAdapter: DataAdapter = DataAdapter()

    init {
        makeApiCall()
    }

    fun getAdapter(): DataAdapter {
        return dataAdapter
    }

    fun setAdapterData(data: ArrayList<MyData>) {
        dataAdapter.setData(data)
        dataAdapter.notifyDataSetChanged()
    }


    private fun makeApiCall() {
        RetrofitClient.getRetrofitInstance().create(ApiEndPoint::class.java)
        repository.getAllRepository("kotlin")
            .enqueue(object : retrofit2.Callback<GithubResponseModel> {
                override fun onFailure(call: Call<GithubResponseModel>, t: Throwable) {
                    _githubResponseData.value = null
                }

                override fun onResponse(
                    call: Call<GithubResponseModel>,
                    response: Response<GithubResponseModel>
                ) {
                    if (!response.isSuccessful) _githubResponseData.value =
                        null else _githubResponseData.value = response.body()
                }
            })
    }
}