package com.rogerferdinan.weather_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogerferdinan.weather_app.data.CurrentWeather
import com.rogerferdinan.weather_app.data.WeatherData
import com.rogerferdinan.weather_app.network.WeatherApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    private val _currentWeatherState = MutableStateFlow(WeatherData())
    val currentWeatherState: StateFlow<WeatherData> = _currentWeatherState.asStateFlow()

    fun getCurrentWeather(latitude: Float, longitude: Float) {
        viewModelScope.launch {
            val result = WeatherApi.api.getForecast(latitude, longitude)
            if(result.isSuccessful) {
                val latitude = result.body()!!.latitude
                val longitude = result.body()!!.longitude
                val currentWeather = result.body()!!.current_weather
                _currentWeatherState.update {currentState ->
                    currentState.copy(latitude = latitude, longitude = longitude, current_weather = currentWeather)
                }
                Log.d("testing", currentWeather.toString())
            }
        }
    }
}