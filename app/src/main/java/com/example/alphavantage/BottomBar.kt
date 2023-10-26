package com.example.alphavantage

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.example.alphavantage.destinations.TypedDestination
import com.example.alphavantage.util.BottomBarDestination
import com.ramcosta.composedestinations.navigation.navigate


@Composable
fun BottomBar(
    navController: NavController
) {
    val currentDestination: TypedDestination<out Any?> =
        navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination

    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction, fun NavOptionsBuilder.() {
                        launchSingleTop = true
                    })
                },
                icon = { Icon(destination.icon, contentDescription = destination.label) },
                label = { Text(destination.label) },
            )
        }
    }
}