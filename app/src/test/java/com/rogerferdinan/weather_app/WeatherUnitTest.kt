package com.rogerferdinan.weather_app

import com.rogerferdinan.weather_app.network.WeatherApi
import com.rogerferdinan.weather_app.network.WeatherService
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WeatherUnitTest {
    @Test
    fun get_current_weather() = runTest() {
        val weatherApi = WeatherApi.api
        launch {
            val result = weatherApi.getForecast(52f, 15f)
            if(result.isSuccessful) {
                print(result.body())
            }
        }
    }
}