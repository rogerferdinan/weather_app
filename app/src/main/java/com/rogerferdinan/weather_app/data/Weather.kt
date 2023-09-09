package com.rogerferdinan.weather_app.data

import androidx.annotation.DrawableRes

data class Weather(
    @DrawableRes
    var icon: Int,
    var degree: Float,
    var title: String
)