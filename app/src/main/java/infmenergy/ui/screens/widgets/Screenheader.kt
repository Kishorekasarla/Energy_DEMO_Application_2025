package infmenergy.ui.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import com.example.bkvenergy.R

@Composable
fun TopBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(color = colorResource(R.color.white)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.bkv_energy_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(70.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.home_info),
            contentDescription = "Info",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(colorResource(id = R.color.Theme_color)),
            modifier = Modifier
                .size(60.dp)
                .padding(end = 16.dp),
        )
    }
    Column {
        Divider(
            color = colorResource(id = R.color.Theme_color),
            thickness = 1.dp
        )
    }
}
