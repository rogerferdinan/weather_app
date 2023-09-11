package com.rogerferdinan.weather_app.network

import com.rogerferdinan.weather_app.data.WeatherUiState
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast")
    suspend fun getForecast(
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float,
        @Query("current_weather") current_weather: Boolean = true
    ): Response<WeatherUiState>
}