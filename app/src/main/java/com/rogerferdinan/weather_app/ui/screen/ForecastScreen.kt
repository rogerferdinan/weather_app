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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rogerferdinan.weather_app.R
import com.rogerferdinan.weather_app.viewmodel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastScreen(
    currentDegree: Float,
    weatherIcon: Int,
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
                WeatherAndDegree(size = 75, degree = currentDegree, weatherIcon = weatherIcon)
            }
            Row(
                modifier = Modifier.weight(2f)
            ) {
                WeatherAndDegree(modifier = Modifier.weight(1f), degree = currentDegree, weatherIcon = weatherIcon)
                WeatherAndDegree(modifier = Modifier.weight(1f), degree = currentDegree, weatherIcon = weatherIcon)
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
    size: Int = 40,
    degree: Float,
    weatherIcon: Int
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Image(
            painter = painterResource(id = weatherIcon),
            contentDescription = null,
            modifier = Modifier.weight(2f)
        )
        Text(text = "${degree}°", fontSize = size.sp, modifier = Modifier.weight(2f))
    }
}
@Composable
@Preview(showBackground = true)
fun preview(){
    var viewModel: WeatherViewModel = viewModel()
    var currentDegree = 10.0f
    ForecastScreen(
        foreCastClick = { /*TODO*/ },
        currentDegree = currentDegree,
        weatherIcon = viewModel.getWeatherIcon(currentDegree)
    ) {

    }
}