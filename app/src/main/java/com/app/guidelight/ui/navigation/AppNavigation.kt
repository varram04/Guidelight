package com.app.guidelight.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.guidelight.DashboardScreen
import com.app.guidelight.ui.route.RouteName
import com.example.notifications.NotificationScreen

@Composable
internal fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = RouteName.LOGIN) {
        composable(RouteName.LOGIN) {

        }
        composable(RouteName.REGISTER) {

        }
        composable(RouteName.DASHBOARD) {
            DashboardScreen()
        }
        composable(RouteName.NOTIFICATION) {
            NotificationScreen()
        }
    }
}