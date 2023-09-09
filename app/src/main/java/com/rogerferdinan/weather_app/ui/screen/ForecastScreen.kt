package com.rogerferdinan.weather_app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rogerferdinan.weather_app.R
import com.rogerferdinan.weather_app.data.Weather

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastScreen(
    foreCastClick: ()-> Unit,
    degree: Float,
    historicalClick: ()-> Unit
){
//    var weather = Weather(
//        icon = R.drawable.baseline_cloud_24,
//        degree = 40f,
//        title = "Indonesia"
//    )

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
                WeatherAndDegree(size = 150, degree = degree)
            }
            Row(
                modifier = Modifier.weight(2f)
            ) {
                WeatherAndDegree(modifier = Modifier.weight(1f), degree = degree)
                WeatherAndDegree(modifier = Modifier.weight(1f), degree = degree)
            }
        }
    }
}



@Composable
private fun TopBar(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_cloud_queue_24),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}
@Composable
private fun BottomBar(
    foreCastClick: ()-> Unit,
    historicalClick: ()-> Unit
){
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
                .clickable { historicalClick() }
        )
    }
}
@Composable
fun WeatherAndDegree(
    modifier: Modifier = Modifier,
    size: Int = 75,
    degree: Float
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
//        Text(text = weather.title, fontSize = 35.sp)
//        Image(
//            painter = painterResource(id = weather.icon),
//            contentDescription = null,
//            modifier = Modifier.size(size.dp)
//        )
        Text(text = "${degree}°", fontSize = 50.sp)
    }
}
//@Composable
//@Preview(showBackground = true)
//fun preview(){
////    WeatherAndDegree()
//    ForecastScreen({}, {})
//}
