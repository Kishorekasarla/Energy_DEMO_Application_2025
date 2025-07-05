package com.infmenergy.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bkvenergy.R
import com.example.bkvenergy.R.string.offers
import com.example.bkvenergy.R.string.usage


sealed class Screen(val route : String,
                    @StringRes val title: Int = R.string.app_title,
                    val navIcon : (@Composable () -> Unit) = {
                        Icon(
                            Icons.Filled.Home, contentDescription = "home"
                        )
                    },
                    val objectName: String = "",
                    val objectPath: String = ""){

    object Login : Screen("login_screen")
    object Home : Screen("home_screen")
    object BillPayment : Screen("bill_payment")

    // Bottom Navigation
    object DashboardNav : Screen("home_screen", title = R.string.home, navIcon = {
        Icon(
            Icons.Filled.Home,
            contentDescription = "search",
            modifier = Modifier
                .padding(end = 16.dp)
                .offset(x = 10.dp)
        )
    })

    object BillNav : Screen("bill_screen", title = R.string.bill, navIcon = {
        Icon(
            Icons.Filled.List,
            contentDescription = "search",
            modifier = Modifier
                .padding(end = 16.dp)
                .offset(x = 10.dp)
        )
    })

    object UsageNav : Screen("usage_screen", title = usage, navIcon = {
        Icon(
            Icons.Filled.DateRange,
            contentDescription = "search",
            modifier = Modifier
                .padding(end = 16.dp)
                .offset(x = 10.dp)
        )
    })

    object OffersNav : Screen("offers_screen", title = offers, navIcon = {
        Icon(
            Icons.Filled.Star,
            contentDescription = "search",
            modifier = Modifier
                .padding(end = 16.dp)
                .offset(x = 10.dp)
        )
    })

    object AccountNav : Screen("accounts_screen", title = R.string.accounts, navIcon = {
        Icon(
            Icons.Filled.AccountBox,
            contentDescription = "search",
            modifier = Modifier
                .padding(end = 16.dp)
                .offset(x = 10.dp)
        )
    })

    object MyPlan : Screen("myplan_screen")
}