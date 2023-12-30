package hu.paulolajos.featuresmodule

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureClass @Inject constructor(){
    val text = "My Feature Class"
}