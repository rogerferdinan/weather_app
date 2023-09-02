package com.rogerferdinan.weather_app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rogerferdinan.weather_app.ui.screen.ForecastScreen
import com.rogerferdinan.weather_app.ui.screen.HistoricalScreen

@Composable
fun WeatherApp(){
    var navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "ForecastScreen"
    ) {
        composable(route = "ForecastScreen"){
            ForecastScreen(
                foreCastClick = {
                    navController.navigate("ForecastScreen")
                }
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