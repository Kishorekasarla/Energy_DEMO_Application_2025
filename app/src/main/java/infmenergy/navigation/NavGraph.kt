package com.infmenergy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bkvenergy.R
import com.infmenergy.ui.screens.bottomnavigation.bill.BillPayment
import com.infmenergy.ui.screens.bottomnavigation.dashboard.Dashboard
import com.infmenergy.ui.screens.bottomnavigation.offers.Offers
import com.infmenergy.ui.screens.bottomnavigation.settings.Settings
import com.infmenergy.ui.screens.bottomnavigation.usage.Usage
import com.infmenergy.ui.screens.login.LoginScreen
import com.infmenergy.ui.screens.myplan.MyPlan

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier) {

   NavHost(navController = navController, startDestination = Screen.Login.route, modifier){

       composable(Screen.Login.route){
          label = stringResource(id = R.string.login)
          LoginScreen(navController = navController)
       }

       composable(Screen.Home.route) {
           label = stringResource(id = R.string.home)
           Dashboard(navController = navController)
       }

       composable(Screen.BillNav.route){
           BillPayment(navHostController = navController)
       }
       
       composable(Screen.UsageNav.route){
           Usage(navController = navController)
       }
       
       composable(Screen.OffersNav.route){
           Offers(navHostController = navController)
       }

       composable(Screen.AccountNav.route){
           Settings(navHostController = navController)
       }

       composable(Screen.MyPlan.route){
           MyPlan(navHostController = navController)
       }
   }

}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route?.substringBeforeLast("/")
}