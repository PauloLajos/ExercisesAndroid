package hu.paulolajos.getcurrentlocation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrentLocationViewModel @Inject constructor(private val locationTracker: LocationTracker):
    ViewModel() {
    fun loadCurrentLocation() {
        viewModelScope.launch {
            // launching a coroutine whose life cycle will be as long as the view-model
            locationTracker.getCurrentLocation()?.let {

                // let is type of scope used to avoid null pointer exceptions
                // so this will work only if location is not null

                //it.latitude it.longitude

            }?:kotlin.run {
                /*state = state.copy(weatherInfo = null,
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS.")
                    
                 */
            }
        }
    }
}
