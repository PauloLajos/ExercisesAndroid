package hu.paulolajos.kotlindsl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.paulolajos.kotlindsl.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val weatherAPI = retrofit.create(WeatherAPI::class.java)
        val weatherCall = weatherAPI.getWeather()
        weatherCall.enqueue(object : Callback<WeatherResult> {
            override fun onResponse(call: Call<WeatherResult>, response: Response<WeatherResult>) {
                mainBinding.textView.text = StringBuilder()
                    .append(response.body()?.main?.temp?.roundToInt().toString())
                    .append(" \u2103") // Celsius: \u2103 Fahrenheit: \u2109
            }

            override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                mainBinding.textView.text = t.message
            }
        })
    }
}