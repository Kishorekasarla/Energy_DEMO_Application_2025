package com.infmenergy.ui.screens.myplan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import infmenergy.ui.screens.widgets.TopBar

@Composable
fun MyPlan(navHostController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.Theme_color)),
    ) {

        TopBar()

        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 50.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxSize()
                .background(color = colorResource(R.color.Theme_color)),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {

            Text(
                text = "My Plan",
                fontSize = 28.sp,
                color = colorResource(R.color.white),
                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
            )

            // First Card - Plan Change Pending
            Card(
                modifier = Modifier
                    .weight(0.25f)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(35.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(R.string.plan_change_pending),
                        fontSize = 18.sp,
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
                    Text(
                        text = stringResource(R.string.a_change_of_plan_text02),
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                }
            }

            // Second Card - Free Power Weekends 24
            Card(
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(35.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(R.string.free_power_weekends_24),
                        fontSize = 18.sp,
                        color = colorResource(R.color.Theme_color),
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Contract Term:\n24 Months",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Plan expires on:\ndec 23, 2025",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Early Cancellation Fee:\n\$135",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )
                        }

                        Spacer(modifier = Modifier.width(24.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Download Information",
                                fontSize = 11.sp,
                                color = Color.DarkGray,
                                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                            )
                            PdfRow(label = "Terms of Service")
                            PdfRow(label = "Customer Rights")
                            PdfRow(label = "Disclosure Statement")
                        }
                    }

                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = stringResource(R.string.if_a_cancellation_fee_is_hsown_it_applies_until_you_recieve_your_contract_expiration_notice),
                        fontSize = 11.sp,
                        lineHeight = 17.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_medium))
                    )
                }
            }

            // Third Card - Key Features
            Card(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(35.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(R.string.key_features),
                        fontSize = 18.sp,
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
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = stringResource(R.string.energy_charge_per_kwh_15_833) +
                                stringResource(R.string.based_charge_per_month_4_95),
                        fontSize = 14.sp,
                        lineHeight = 17.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = stringResource(R.string.this_pricing_was_effective_as_of_06_06_2023),
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
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

@Composable
fun PdfRow(label: String) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 4.dp)) {
        Image(
            painterResource(R.drawable.pdf),
            contentDescription = "pdf icon",
            modifier = Modifier.size(12.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = colorResource(R.color.Theme_color),
            fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
        )
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
