package hu.paulolajos.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import hu.paulolajos.daggerhilt.MainViewModel
import hu.paulolajos.daggerhilt.R
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import hu.paulolajos.daggerhilt.data.CryptocurrencyAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var cryptocurrencyList: RecyclerView

    // viewModels() delegate used to get
    // by view models will automatically construct the ViewModels using Hilt
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cryptocurrencyList = findViewById<RecyclerView>(R.id.cryptocurrency_list)
        cryptocurrencyList.layoutManager = LinearLayoutManager(this)

        observeCryptoCurrency()
    }

    // Observing the live data
    private fun observeCryptoCurrency() {
        viewModel.cryptoCurrency.observe(this) {
            cryptocurrencyList.adapter = CryptocurrencyAdapter(it)
        }
    }
}