package com.infmenergy.ui.screens.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bkvenergy.R
import com.infmenergy.navigation.Navigation
import com.infmenergy.navigation.Screen
import com.infmenergy.navigation.currentRoute

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.Theme_color))
            .windowInsetsPadding(WindowInsets.systemBars),
        bottomBar = {
            when (currentRoute(navController)) {
                Screen.DashboardNav.route,
                Screen.BillNav.route,
                Screen.UsageNav.route,
                Screen.OffersNav.route,
                Screen.AccountNav.route -> {
                    Column {
                        Divider(
                            color = Color.White,
                            thickness = 1.dp
                        )
                        BottomNavigationUI(navController = navController)
                    }
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
        containerColor = colorResource(R.color.Theme_color)
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
            val isSelected = currentRouteValue == item.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .then(
                                if (isSelected) Modifier
                                    .background(
                                        color = colorResource(R.color.Bkv_theme_color2),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .padding(horizontal = 12.dp, vertical = 8.dp)
                                else Modifier
                            )
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            item.navIcon()
                            Text(
                                text = stringResource(id = item.title),
                                color = if (isSelected) Color.White else Color.White.copy(alpha = 0.4f),
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                },
                alwaysShowLabel = false, // We're rendering label manually
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White.copy(alpha = 0.4f),
                    selectedTextColor = Color.Transparent,
                    unselectedTextColor = Color.Transparent,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
