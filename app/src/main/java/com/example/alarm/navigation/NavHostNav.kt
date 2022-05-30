package com.example.alarm.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.alarm.ui.alarm.AlarmScreen
import com.example.alarm.ui.clock.ClockScreen
import com.example.alarm.ui.stopwatch.StopwatchScreen
import com.example.alarm.ui.theme.Theme
import com.example.alarm.ui.timer.TimerScreen

@Composable
fun NavHostNav(
    navController: NavHostController = rememberNavController(),
    background: Color
) {
    val items = listOf(
        Screen.Alarm,
        Screen.Clock,
        Screen.Timer,
        Screen.Stopwatch
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .height(72.dp),
                backgroundColor = Theme.colors.secondaryBackground
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.iconId),
                                contentDescription = null,
                                tint = Theme.colors.activeTextColor
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*do something*/ },
                modifier = Modifier.size(64.dp),
                backgroundColor = Theme.colors.buttonBackground
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Localized description",
                    Modifier.size(20.dp)
                )
            }
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = NavigationTree.Alarm.name,
            modifier = Modifier
                .fillMaxSize()
                .background(color = background)
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
        ) {
            composable(NavigationTree.Alarm.name) {
                AlarmScreen()
            }
            composable(NavigationTree.Clock.name) { ClockScreen() }
            composable(NavigationTree.Stopwatch.name) { StopwatchScreen() }
            composable(NavigationTree.Timer.name) { TimerScreen() }
        }
    }
}