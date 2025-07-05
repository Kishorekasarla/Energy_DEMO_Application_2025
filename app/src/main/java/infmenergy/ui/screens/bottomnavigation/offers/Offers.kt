package com.infmenergy.ui.screens.bottomnavigation.offers

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun Offers(navHostController: NavHostController) {
    val context = LocalContext.current
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.summitutilities.com/offers"))

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(bottom = 20.dp)
    ) {
        // Top bar row
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

        Column(
            Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Thank you for being a loyal customer. Below are offers brought to you by Summit Utilities.",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 24.dp),
                fontFamily = FontFamily(Font(R.font.mona_sans_medium)),
            )

            offersList.forEach { offer ->
                Card(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .clickable {
                            context.startActivity(webIntent)
                        },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = offer.image),
                            contentDescription = "Offer Image",
                            modifier = Modifier
                                .height(60.dp)
                                .width(60.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = offer.description,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f),
                            fontFamily = FontFamily(Font(R.font.sf_pro_regular))
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "Arrow Icon",
                            modifier = Modifier.size(45.dp)
                        )
                    }
                }
            }
        }
    }
}

val offersList = listOf(
    Offer(
        R.drawable.offer_image_1,
        "Get your peace of mind with $1000 annual coverage in the event of unexpected damage from an electrical surge or lightning strike."
    ),
    Offer(
        R.drawable.offer_image_1,
        "Get your peace of mind with $2000 annual coverage in the event of unexpected damage from an electrical surge or lightning strike."
    ),
    Offer(
        R.drawable.offer_image_2,
        "Get protection and $5000 annual coverage for unexpected AC and heating repair costs."
    ),
    Offer(
        R.drawable.offer_image_2,
        "Get cover for up to $1000/year for electrical wiring repairs AND up to $1000/year for surge damage."
    )
)

data class Offer(val image: Int, val description: String)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InfmEnergyTheme {
        val navController = rememberNavController()
        Offers(navController)
    }
}
