package com.app.guidelight.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.guidelight.DashboardScreen
import com.app.guidelight.RegisterForm
import com.app.guidelight.ui.route.RouteName
import com.example.logincomposeapp.LoginScreen
import com.example.notifications.NotificationScreen

@Composable
internal fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = RouteName.LOGIN) {
        composable(RouteName.LOGIN) {
            LoginScreen(onLoginClick = {
                navController.navigate(RouteName.DASHBOARD) {
                    popUpTo(RouteName.LOGIN) {
                        inclusive = true
                    }
                }
            },
                onRegisterClick = { navController.navigate(RouteName.REGISTER) })
        }
        composable(RouteName.REGISTER) {
            RegisterForm {
                navController.popBackStack()
            }
        }
        composable(RouteName.DASHBOARD) {
            DashboardScreen(
                onLogoutClick = { navController.navigate(RouteName.LOGIN) },
                onNotificationClick = { navController.navigate(RouteName.NOTIFICATION) })
        }
        composable(RouteName.NOTIFICATION) {
            NotificationScreen()
        }
    }
}