package com.infmenergy.ui.screens.bottomnavigation.bill

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import infmenergy.ui.screens.widgets.TopBar

@Composable
fun BillDashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ClickableIconWithTitle(
                iconRes = R.drawable.home_view_bill,
                title = "View Bill"
            )
            ClickableIconWithTitle(
                iconRes = R.drawable.home_bill_history,
                title = "Bill History"
            )
            ClickableIconWithTitle(
                iconRes = R.drawable.home_payments_methods,
                title = "Payments\nMethods"
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ClickableIconWithTitle(
                iconRes = R.drawable.home_payment_history,
                title = "Payment\nHistory"
            )
            ClickableIconWithTitle(
                iconRes = R.drawable.home_manage_autopay,
                title = "Manage\nAutopay"
            )
            ClickableIconWithTitle(
                iconRes = R.drawable.home_billing_options,
                title = " Billing\nOptions"
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        TextCard(text = "What Changed?")
    }
}

@Composable
fun ClickableIconWithTitle(iconRes: Int, title: String) {
    Card(
        modifier = Modifier
            .width(125.dp)
            .height(150.dp)
            .clickable { }
            .fillMaxWidth()
            .padding(1.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = title,
                color = colorResource(R.color.Theme_color),
                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
            )
        }
    }
}

@Composable
fun TextCard(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                color = colorResource(R.color.Theme_color),
                fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
            )
        }
    }
}


@Composable
fun BillPayment(navHostController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = colorResource(R.color.Theme_color))
    ) {

        Column(
            modifier = Modifier
                .padding()
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
        ) {
            TopBar()

            Card(
                modifier = Modifier
                    .padding(top = 15.dp, start = 30.dp, end = 30.dp, bottom = 20.dp)
                    .fillMaxWidth()
                    .fillMaxSize(0.28f),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                shape = RoundedCornerShape(40.dp)
            ) {
                Column(
                    modifier = Modifier.padding(end = 5.dp, top = 15.dp)
                            .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 4.dp),
                        text = "Amount Due",
                        fontSize = 25.sp,
                        color = colorResource(R.color.Theme_color),
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 4.dp),
                        text = "$60.30",
                        fontSize = 25.sp,
                        color = colorResource(R.color.Bkv_theme_color2),
                        fontFamily = FontFamily(Font(R.font.sf_pro_semibold))
                    )
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .padding()
                            .height(45.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.Theme_color)  // note: containerColor in material3
                        ),
                        enabled = true,
                        border = BorderStroke(
                            width = 2.dp,
                            color = colorResource(R.color.Theme_color)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                    {
                        Text(
                            text = "Pay Now",
                            fontSize = 20.sp,
                            color = colorResource(R.color.white),
                            fontFamily = FontFamily(Font(R.font.sf_pro_semibold))

                        )
                    }


                    Text(
                        modifier = Modifier.padding(bottom = 4.dp, top = 4.dp),
                        text = "Autopay scheduled for \n           08/08/2023",
                        fontSize = 14.sp,
                        color = colorResource(R.color.Theme_color),
                        fontFamily = FontFamily(Font(R.font.mona_sans_medium))
                    )


                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .fillMaxSize(0.61f)
            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Card(
                    modifier = Modifier.fillMaxSize(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                ) {
                    BillDashboard()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BillPaymentPreview() {
    InfmEnergyTheme {
        val navController = rememberNavController()
        BillPayment(navController)
    }
}