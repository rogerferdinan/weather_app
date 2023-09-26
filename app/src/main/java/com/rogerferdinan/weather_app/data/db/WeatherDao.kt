package com.rogerferdinan.weather_app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rogerferdinan.weather_app.data.WeatherDb
import com.rogerferdinan.weather_app.data.WeatherUiState
import retrofit2.Response

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weatherdb ORDER BY wId DESC LIMIT 1")
    fun getLastData(): WeatherDb
    @Insert
    fun insert(vararg weatherDb: WeatherDb)
}