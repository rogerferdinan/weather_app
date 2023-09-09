package com.rogerferdinan.weather_app.data

data class WeatherData (
    val latitude: Float = 0f,
    val longitude: Float = 0f,
    val current_weather: CurrentWeather = CurrentWeather(0f, 0f, 0)
)