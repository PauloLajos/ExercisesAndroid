package hu.paulolajos.ui

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import hu.paulolajos.ui.base.BaseActivity
import hu.paulolajos.ui.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object{
        var isAnimatedRecyclerView : Boolean = false
    }

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        isAnimatedRecyclerView = true
    }
}
