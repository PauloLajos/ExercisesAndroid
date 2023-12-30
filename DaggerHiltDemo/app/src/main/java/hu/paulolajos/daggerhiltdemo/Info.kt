package hu.paulolajos.daggerhiltdemo

import javax.inject.Inject

class Info @Inject constructor() {
    val text = "Hello Dagger Hilt"
}