package com.infmenergy.ui.screens.mainscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.infmenergy.navigation.Navigation
import com.infmenergy.navigation.Screen
import com.infmenergy.navigation.currentRoute

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            when (currentRoute(navController)) {
                Screen.DashboardNav.route,
                Screen.BillNav.route,
                Screen.UsageNav.route,
                Screen.OffersNav.route,
                Screen.AccountNav.route -> {
                    BottomNavigationUI(navController = navController)
                }
                else -> {
                    // No bottom bar
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Navigation(navController, Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun BottomNavigationUI(navController: NavController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        val items = listOf(
            Screen.DashboardNav,
            Screen.BillNav,
            Screen.UsageNav,
            Screen.OffersNav,
            Screen.AccountNav
        )

        val currentRouteValue = currentRoute(navController)

        items.forEach { item ->
            NavigationBarItem(
                icon = item.navIcon,
                label = { Text(text = stringResource(id = item.title)) },
                selected = currentRouteValue == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White.copy(alpha = 0.4f),
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White.copy(alpha = 0.4f),
                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        }
    }
}
