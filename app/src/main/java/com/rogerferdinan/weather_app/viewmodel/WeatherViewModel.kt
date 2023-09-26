package com.rogerferdinan.weather_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.rogerferdinan.weather_app.R
import com.rogerferdinan.weather_app.data.Weather
import com.rogerferdinan.weather_app.data.WeatherUiState
import com.rogerferdinan.weather_app.data.db.WeatherDao
import com.rogerferdinan.weather_app.network.WeatherApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import kotlin.math.roundToInt

class WeatherViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

//    init {
//        getCurrentWeather(-6.2146f, 106.8451f)
//    }
    fun getCurrentWeather(latitude: Float, longitude: Float, weatherDao: WeatherDao) {
        viewModelScope.launch {
            val result = WeatherApi.api.getForecast(latitude, longitude, forecast_days = 3)

            if(result.isSuccessful) {
                // jika online
                val latitude = result.body()!!.latitude
                val longitude = result.body()!!.longitude
                val currentWeather = result.body()!!.current_weather
                val daily = result.body()!!.daily
                _uiState.update {currentState ->
                    currentState.copy(
                        latitude = latitude,
                        longitude = longitude,
                        current_weather = currentWeather,
                        daily = daily
                    )
                }
//                val weather = WeatherUiState(latitude, longitude, currentWeather, daily)
//                weatherDao.insert(weather)
            }else{
                // jika offline
                val weatherData = weatherDao.getLastData()

//                if(weatherData != null){ // Buat hindarin miss data type karena nullable
//                    val latitude = weatherData.latitude
//                    val longitude = weatherData.longitude
//                    val currentWeather = weatherData.current_weather
//                    val daily = weatherData.daily
//                    _uiState.update {currentState ->
//                        currentState.copy(
//                            latitude = latitude,
//                            longitude = longitude,
//                            current_weather = currentWeather,
//                            daily = daily
//                        )
//                    }
//                }

            }
        }
    }
    fun getWeatherIcon(degree: Float): Int{
        if(degree<15.0f) return R.drawable.cold
        else if(degree>=15 && degree<30) return R.drawable.cloudy
        else return R.drawable.hot
    }
    fun toKmPerHour(windspeed: Float): Float{
        var number = windspeed*1.8f
        number = (number*100).roundToInt() / 100.0f
        return number
    }
    fun databaseIsEmpty(weatherDao: WeatherDao){
        val data = weatherDao.getLastData()
        if(data == null) {
//            val weather = WeatherUiState(0.0f, 0.0f, Weather(0f, 0f, 0))
//            weatherDao.insert(weather)
        }
    }
}