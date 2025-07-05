package com.infmenergy.ui.screens.myplan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bkvenergy.R
import com.infmenergy.ui.theme.InfmEnergyTheme

@Composable
fun MyPlan(navHostController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = colorResource(R.color.Theme_color))
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
                painterResource(R.drawable.summitlogowhite),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(120.dp)
            )

            Image(
                painterResource(R.drawable.home_info),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(45.dp)
                    .padding(end = 16.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 30.dp, top = 30.dp, end = 45.dp, bottom = 30.dp),

            ) {


            Text(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 25.dp),
                text = "My Plan",
                fontSize = 30.sp,
                color = colorResource(R.color.white),
                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
            )
            Card(
                modifier = Modifier

                    .height(220.dp)
                    .clickable { }
                    .fillMaxWidth()
                    .padding(top = 25.dp),


                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),

                shape = RoundedCornerShape(35.dp)

            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 15.dp),
                        text = stringResource(R.string.plan_change_pending),
                        fontSize = 19.sp,
                        color = colorResource(R.color.Theme_color),
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Text(
                        text = stringResource(R.string.a_change_of_plan_text01),
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = stringResource(R.string.a_change_of_plan_text02),
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                }


            }


            Card(
                modifier = Modifier

                    .height(260.dp)
                    .clickable { }
                    .fillMaxWidth()
                    .padding(top = 25.dp),

                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(35.dp)

            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),

                    ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 10.dp),
                        text = stringResource(R.string.free_power_weekends_24),
                        fontSize = 19.sp,
                        color = colorResource(R.color.Theme_color),
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )

                    Row() {
                        Column {
                            Text(
                                text = "Contract Term:\n" +
                                        "24 Months",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Text(
                                text = "Plan expires on:\n" +
                                        "Apr 23, 2024",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )

                            Spacer(modifier = Modifier.size(8.dp))
                            Text(
                                text = "Early Cancellation Fee:\n" +
                                        "\$135",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(start = 35.dp),
                        ) {
                            Text(
                                text = "Download Information",
                                fontSize = 11.sp,
                                color = Color.DarkGray,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )

                            Row(modifier = Modifier.padding(top = 3.dp)) {
                                Image(
                                    painterResource(R.drawable.pdf),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(10.dp)
                                )
                                Text(
                                    modifier = Modifier.padding(start = 3.dp),
                                    text = "Terms of Service",
                                    fontSize = 11.sp,
                                    color = colorResource(R.color.Theme_color),
                                    fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                                )
                            }

                            Row(modifier = Modifier.padding(top = 5.dp)) {
                                Image(
                                    painterResource(R.drawable.pdf),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(10.dp)
                                )
                                Text(
                                    modifier = Modifier.padding(start = 3.dp),
                                    text = "Customer Rights",
                                    fontSize = 11.sp,
                                    color = colorResource(R.color.Theme_color),
                                    fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                                )
                            }
                            Row(modifier = Modifier.padding(top = 3.dp)) {
                                Image(
                                    painterResource(R.drawable.pdf),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(10.dp)
                                )
                                Text(
                                    modifier = Modifier.padding(start = 3.dp),
                                    text = "Disclosure Statement",
                                    fontSize = 11.sp,
                                    color = colorResource(R.color.Theme_color),
                                    fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                                )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = stringResource(R.string.if_a_cancellation_fee_is_hsown_it_applies_until_you_recieve_your_contract_expiration_notice),
                        fontSize = 11.sp,
                        lineHeight = 17.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                    )
                }

            }
            Card(
                modifier = Modifier
                    .height(240.dp)
                    .clickable { }
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(35.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),

                    ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 10.dp),
                        text = stringResource(R.string.key_features),
                        fontSize = 19.sp,
                        color = colorResource(R.color.Theme_color),
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Text(

                        text = stringResource(R.string.average_price_13_9_per_kwh_based_on_2000_kwh_includes_the_following),
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = stringResource(R.string.energy_charge_per_kwh_15_833) +
                                stringResource(R.string.based_charge_per_month_4_95),
                        fontSize = 15.sp,
                        lineHeight = 17.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = stringResource(R.string.this_pricing_was_effective_as_of_06_06_2023),
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = stringResource(R.string.please_refer_to_your_el_for_other_details_about_your_plan),
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPlanPreview() {
    InfmEnergyTheme {
        val navController = rememberNavController()
        MyPlan(navController)
    }
}