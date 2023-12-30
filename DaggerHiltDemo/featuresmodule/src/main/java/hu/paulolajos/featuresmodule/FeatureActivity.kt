package hu.paulolajos.featuresmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import hu.paulolajos.featuresmodule.databinding.ActivityFeatureBinding
import javax.inject.Inject

@AndroidEntryPoint
class FeatureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeatureBinding

    @Inject
    lateinit var featureClass: FeatureClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeatureBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvText.text = featureClass.text
    }
}