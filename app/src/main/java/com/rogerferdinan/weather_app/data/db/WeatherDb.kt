package com.rogerferdinan.weather_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherDb(
    @PrimaryKey(autoGenerate = true)
    val wId: Int,
    @ColumnInfo(name = "latitude")
    val latitude: Float?,
    @ColumnInfo(name = "longtitude")
    val longitude: Float?,
    @ColumnInfo(name = "current_weather")
    val current_weather: Weather?,
    @ColumnInfo(name = "daily_weather")
    val daily: DailyWeather?
)
