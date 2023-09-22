package com.rogerferdinan.weather_app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rogerferdinan.weather_app.data.WeatherDb

@Database(entities = [WeatherDb::class], version = 1)
@TypeConverters(WeatherConverters::class, DailyWeatherConverters::class)
abstract class WeatherAppDb: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}