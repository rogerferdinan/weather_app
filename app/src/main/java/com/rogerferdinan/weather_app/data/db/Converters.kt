package com.rogerferdinan.weather_app.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.rogerferdinan.weather_app.data.DailyWeather
import com.rogerferdinan.weather_app.data.Weather
import com.rogerferdinan.weather_app.data.WeatherUiState

class WeatherConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromWeather(weather: Weather): String{
        return gson.toJson(weather)
    }

    @TypeConverter
    fun toWeather(data: String): Weather{
        return gson.fromJson(data, Weather::class.java)
    }
}

class DailyWeatherConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromDailyWeather(dailyWeather: DailyWeather): String{
        return gson.toJson(dailyWeather)
    }
    @TypeConverter
    fun toDailyWeather(data: String): DailyWeather{
        return gson.fromJson(data, DailyWeather::class.java)
    }
}
