package hu.paulolajos.featuresmodule

import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object InterfaceFeatureObjectModule {

    @ActivityScoped
    @Provides
    @Named("FeatureOne")
    fun provideInterfaceFeatureObject(): InterfaceFeatureObject {
        return object: InterfaceFeatureObject {
            override val text: String = "Interface Feature 1 Object Impl"
        }
    }
}

interface InterfaceFeatureObject {
    val text: String
}