package com.rogerferdinan.weather_app.data

import androidx.annotation.DrawableRes

data class Weather(
    @DrawableRes
    val icon: Int,
    val degree: Int,
    val title: String
)