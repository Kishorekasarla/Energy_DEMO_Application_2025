package com.infmenergy.ui.screens.bottomnavigation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bkvenergy.R
import com.infmenergy.ui.theme.InfmEnergyTheme

@Composable
fun Settings(navHostController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFf3f5f9))
    ) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(color = colorResource(R.color.Theme_color)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.summitlogowhite),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(120.dp)
            )

            Image(
                painterResource(R.drawable.home_info),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(45.dp)
                    .padding(end = 16.dp)
            )
        }

        // User info section
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(top = 16.dp, start = 32.dp, end = 32.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.nature_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = "Mark",
                        fontSize = 22.sp,
                        color = colorResource(id = R.color.Theme_color),
                        fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                    )
                    Text(
                        text = "Account: 18672223-8",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                    )
                }
            }

            Divider(modifier = Modifier.padding(vertical = 16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.location_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = "3500 Springdale Rd",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.sf_pro_regular))
                    )
                    Text(
                        text = "Fort worth, Dallas - 76123",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.sf_pro_regular))
                    )
                }
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Settings options section
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(top = 16.dp, start = 32.dp, end = 32.dp)
        ) {

            val items = listOf(
                Pair(R.drawable.profile_icon, "Profile"),
                Pair(R.drawable.messages_icon, "Messages"),
                Pair(R.drawable.settings_icon, "Settings"),
                Pair(R.drawable.billing_options_icon, "Billing Options"),
                Pair(R.drawable.move_my_service_icon, "Move My Service"),
                Pair(R.drawable.renew_my_service_icon, "Renew My Service")
            )

            items.forEachIndexed { index, (iconRes, label) ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )

                    Text(
                        text = label,
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f),
                        fontFamily = FontFamily(Font(R.font.sf_pro_regular))
                    )

                    Image(
                        painter = painterResource(R.drawable.accounts_right_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                }

                Divider(modifier = Modifier.padding(bottom = 16.dp))
            }

            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.Theme_color))
            ) {
                Text(text = "LOG OUT", color = Color.White)
            }

            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InfmEnergyTheme {
        val navController = rememberNavController()
        Settings(navController)
    }
}
