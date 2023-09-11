package com.rogerferdinan.weather_app.data

data class WeatherUiState (
    val latitude: Float = 0f,
    val longitude: Float = 0f,
    val current_weather: Weather = Weather(0f, 0f, 0),
    val tommorrow_weather: Weather = Weather(0f, 0f, 0),
    val secondTommorrow_weather: Weather = Weather(0f, 0f, 0)

)