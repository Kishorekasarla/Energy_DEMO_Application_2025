package com.infmenergy.ui.screens.bottomnavigation.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bkvenergy.R
import com.infmenergy.navigation.Screen
import com.infmenergy.ui.screens.login.setStatusBarColor
import com.infmenergy.ui.theme.InfmEnergyTheme
import infmenergy.ui.screens.widgets.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                .padding(horizontal = 0.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            TopBar()

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.Theme_color))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.hello_john),
                        fontSize = 12.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.mona_sans_medium))
                    )

                    Text(
                        text = stringResource(R.string.welcome_back),
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )

                    Card(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                            .fillMaxWidth()
                            .height(160.dp),
                        shape = RoundedCornerShape(40.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(top = 25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(R.string.amount),
                                fontSize = 25.sp,
                                color = colorResource(R.color.Bkv_theme_color2),
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
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.view_bill_details),
                                    fontSize = 14.sp,
                                    color = colorResource(R.color.Theme_color),
                                    fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Image(
                                    painter = painterResource(R.drawable.home_view_icon),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .fillMaxHeight(0.61f)
                        .padding(horizontal = 20.dp)
                ) {
                    DashboardScreen(navController)
                }
            }
        }
    }
}

data class CardItem(
    val iconRes: Int,
    val textResId: Int,
    val descriptionResId: Int,
    val subDescriptionResId: Int? = null
)

@Composable
fun DashboardScreen(navController: NavController) {
    val subDescriptionFontSize = 11.sp

    val cardItems = listOf(
        CardItem(
            R.drawable.home_last_7_days,
            R.string.last_7_days,
            R.string._415_5ccf_499_57,
            R.string._22_32_more_than_previous_7_day_period
        ),
        CardItem(
            R.drawable.home_autopay,
            R.string.autopay,
            R.string.sign_up_now,
            null
        ),
        CardItem(
            R.drawable.home_average_billing,
            R.string.average_billing,
            R.string._0_00,
            null
        ),
        CardItem(
            R.drawable.home_my_plan,
            R.string.my_plan,
            R.string.you_are_eligible_to_change_plans,
            null
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = false
    ) {
        items(cardItems) { item ->
            DashboardIcon(
                iconRes = item.iconRes,
                textResId = item.textResId,
                descriptionResId = item.descriptionResId,
                subDescriptionResId = item.subDescriptionResId,
                subDescriptionFontSize = subDescriptionFontSize,
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardIcon(
    iconRes: Int,
    textResId: Int,
    descriptionResId: Int,
    subDescriptionResId: Int?,
    subDescriptionFontSize: TextUnit,
    navController: NavController
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)  // Fixed height for all cards
            .padding(4.dp),
        onClick = {
            when (textResId) {
                R.string.my_plan -> navController.navigate(Screen.MyPlan.route)
                // Add more navigation cases if needed
            }
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(id = textResId),
                color = colorResource(R.color.Theme_color),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                maxLines = 2
            )
            Text(
                text = stringResource(id = descriptionResId),
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                maxLines = 2
            )
            if (subDescriptionResId != null) {
                Text(
                    text = stringResource(id = subDescriptionResId),
                    color = Color.DarkGray,
                    fontSize = subDescriptionFontSize,
                    textAlign = TextAlign.Center,
                    maxLines = 2
                )
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
