package com.infmenergy.ui.screens.bottomnavigation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bkvenergy.R
import com.infmenergy.navigation.Screen
import com.infmenergy.ui.theme.InfmEnergyTheme

@Composable
fun DashboardScreen(navController: NavController) {

    val subDescriptionFontSize = 11.sp

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            DashboardRow(
                icons = listOf(
                    Triple(
                        R.drawable.home_last_7_days,
                        stringResource(R.string.last_7_days),
                        stringResource(R.string._415_5ccf_499_57) to stringResource(R.string._22_32_more_than_previous_7_day_period)
                    ),
                    Triple(
                        R.drawable.home_autopay,
                        "AutoPay",
                        "Sign up now" to ""
                    )
                ),
                subDescriptionFontSize = subDescriptionFontSize,
                navController = navController
            )
            DashboardRow(
                icons = listOf(
                    Triple(
                        R.drawable.home_average_billing,
                        stringResource(R.string.average_billing),
                        stringResource(R.string._0_00) to ""
                    ),
                    Triple(
                        R.drawable.home_my_plan,
                        stringResource(R.string.my_plan),
                        stringResource(R.string.you_are_eligible_to_change_plans) to ""
                    )
                ),
                subDescriptionFontSize = subDescriptionFontSize,
                navController = navController
            )
        }
    }
}

@Composable
fun DashboardRow(
    icons: List<Triple<Int, String, Pair<String, String>>>,
    subDescriptionFontSize: TextUnit,
    navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    ) {
        for ((iconRes, text, descriptions) in icons) {
            DashboardIcon(
                iconRes = iconRes,
                text = text,
                description = descriptions.first,
                subDescription = descriptions.second,
                subDescriptionFontSize = subDescriptionFontSize,
                navController = navController
            )
        }
    }
}

@Composable
fun DashboardIcon(
    iconRes: Int,
    text: String,
    description: String,
    subDescription: String,
    subDescriptionFontSize: TextUnit,
    navController: NavController
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .width(185.dp)
            .height(220.dp)
            .padding(top = 20.dp),
        onClick = {
            when (text) {
                "My Plan" -> navController.navigate(Screen.MyPlan.route)
                // Add other cases if needed
            }
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                color = colorResource(R.color.Theme_color),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = description,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = subDescription,
                color = Color.DarkGray,
                fontSize = subDescriptionFontSize
            )
        }
    }
}

@Composable
fun Dashboard(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.Theme_color))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = colorResource(R.color.Theme_color)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.summitlogowhite),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(120.dp)
                )

                Image(
                    painter = painterResource(R.drawable.home_info),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(45.dp)
                        .padding(end = 16.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.Theme_color))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                ) {

                    Text(
                        modifier = Modifier.padding(start = 163.dp, top = 13.dp),
                        text = stringResource(R.string.hello_mark),
                        fontSize = 12.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.mona_sans_medium))
                    )

                    Text(
                        modifier = Modifier.padding(start = 130.dp),
                        text = stringResource(R.string.welcome_back),
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )

                    Card(
                        modifier = Modifier
                            .padding(top = 20.dp, start = 30.dp, end = 30.dp, bottom = 20.dp)
                            .fillMaxWidth()
                            .fillMaxHeight(0.24f),
                        shape = RoundedCornerShape(40.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(top = 25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier.padding(bottom = 3.dp),
                                text = stringResource(R.string.amount),
                                fontSize = 25.sp,
                                color = colorResource(R.color.Amount_color),
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )

                            Text(
                                modifier = Modifier.padding(bottom = 3.dp),
                                text = stringResource(R.string.make_a_payment),
                                fontSize = 16.sp,
                                color = colorResource(R.color.Theme_color),
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )

                            Text(
                                modifier = Modifier.padding(bottom = 3.dp),
                                text = stringResource(R.string.you_have_a_credit_balance),
                                fontSize = 11.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.mona_sans_medium))
                            )
                            Row(
                                modifier = Modifier.padding(start = 14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier.padding(top = 4.dp),
                                    text = stringResource(R.string.view_bill_details),
                                    fontSize = 14.sp,
                                    color = colorResource(R.color.Theme_color),
                                    fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                                )
                                Image(
                                    painter = painterResource(R.drawable.home_view_icon),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomEnd)
                        .fillMaxHeight(0.61f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Card(
                            modifier = Modifier.fillMaxSize(),
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)

                        ) {
                            DashboardScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InfmEnergyTheme {
        val navController = rememberNavController()
        Dashboard(navController)
    }
}
