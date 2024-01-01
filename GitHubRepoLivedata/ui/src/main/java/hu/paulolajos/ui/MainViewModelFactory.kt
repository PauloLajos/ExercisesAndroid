package hu.paulolajos.ui

/**
 * As you can see from the code above we pass the respository to viewModel which will call for the
 * data from webservice.
 *
 * Please note that for passing parameter’s in viewmodel constructor we need to create
 * ViewModel Factory.
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.paulolajos.data.repository.GithubRepository

class MainViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            repository = GithubRepository()
        ) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}