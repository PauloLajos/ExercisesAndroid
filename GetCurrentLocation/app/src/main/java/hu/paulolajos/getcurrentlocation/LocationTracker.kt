package hu.paulolajos.getcurrentlocation

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}