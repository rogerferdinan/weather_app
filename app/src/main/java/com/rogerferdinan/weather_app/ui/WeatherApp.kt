package com.rogerferdinan.weather_app.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rogerferdinan.weather_app.ui.screen.ForecastScreen
import com.rogerferdinan.weather_app.ui.screen.HistoricalScreen
import com.rogerferdinan.weather_app.viewmodel.WeatherViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun WeatherApp(){
    var navController = rememberNavController()
    var ui_state: WeatherViewModel = viewModel()

    val degree by ui_state.currentWeatherState.collectAsState()
    ui_state.getCurrentWeather(-6.2146f, 106.8451f)

    NavHost(
        navController = navController,
        startDestination = "ForecastScreen"
    ) {
        composable(route = "ForecastScreen"){
            ForecastScreen(
                foreCastClick = {
                    navController.navigate("ForecastScreen")
                },
                degree = degree.current_weather.temperature
            ){
                navController.navigate("HistoricalScreen")
            }
        }
        composable(route = "HistoricalScreen"){
            HistoricalScreen(
                foreCastClick = {
                    navController.navigate("ForecastScreen")
                }
            ) {
                navController.navigate("HistoricalScreen")
            }
        }
    }
}