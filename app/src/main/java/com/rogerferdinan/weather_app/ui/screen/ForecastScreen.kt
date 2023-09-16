package com.rogerferdinan.weather_app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.rogerferdinan.weather_app.R
import com.rogerferdinan.weather_app.ui.WeatherApp
import com.rogerferdinan.weather_app.viewmodel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastScreen(
    currentDegree: Float,
    foreCastDegree: List<Float>,
    weatherIcon: Int,
    windSpeed: Float,
    foreCastClick: ()-> Unit,
    historicalClick: ()-> Unit
){
    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            BottomBar(
                foreCastClick = foreCastClick,
                historicalClick = historicalClick
            )
        }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {
            Row(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                WeatherAndDegree(size = 30, degree = currentDegree, weatherIcon = weatherIcon, windSpeed = windSpeed)
            }
            Row(
                modifier = Modifier.weight(2f)
            ) {
                foreCastDegree.forEach {degree ->
                    WeatherAndDegree(
                        degree = degree,
                        weatherIcon = weatherIcon,
                        windSpeed = windSpeed,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}
@Composable
private fun TopBar(){
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_cloud_queue_24),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                tint = Color(0xff16C6F5)
            )
        }
        Divider(
            thickness = 2.dp,
            color = Color.Black
        )
    }
}
@Composable
private fun BottomBar(
    foreCastClick: ()-> Unit,
    historicalClick: ()-> Unit
){
    Divider(
        thickness = 2.dp,
        color = Color.Black
    )
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_cloud_circle_24),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .weight(1f)
                .clickable { foreCastClick() }
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_cloud_done_24),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .weight(1f)
                .clickable { historicalClick() },
            tint = Color(0xff22F8FC)
        )
    }
}
@Composable
fun WeatherAndDegree(
    modifier: Modifier = Modifier,
    size: Int=20,
    degree: Float,
    windSpeed: Float,
    weatherIcon: Int
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Image(
            painter = painterResource(id = weatherIcon),
            contentDescription = null
        )
        Text(
            text = "${degree}°",
            fontSize = size.sp
        )
        Text(
            text = "${windSpeed}Km/H",
            fontSize = size.sp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun preview(){
    var viewModel: WeatherViewModel = viewModel()
    WeatherAndDegree(degree = 30f, windSpeed = 20f, weatherIcon = viewModel.getWeatherIcon(30f))
}