package com.rogerferdinan.weather_app.data.db

import androidx.room.Insert
import androidx.room.Query
import com.rogerferdinan.weather_app.data.WeatherUiState
import retrofit2.Response

interface WeatherDao {
    @Query("SELECT * FROM weatherdb ORDER BY wId DESC LIMIT 1;")
    fun getLastData(): WeatherUiState?
    @Insert
    fun insert(vararg weatherUiState: WeatherUiState)
}