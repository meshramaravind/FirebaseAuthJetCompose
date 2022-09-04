package com.arvind.firebaseauthjetcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arvind.firebaseauthjetcompose.view.HomeScreen
import com.arvind.firebaseauthjetcompose.view.LoginScreen
import com.arvind.firebaseauthjetcompose.view.SignUpScreen
import com.arvind.firebaseauthjetcompose.viewmodel.AuthViewModel

@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(navController,viewModel)
        }
        composable(ROUTE_SIGNUP) {
            SignUpScreen(navController,viewModel)
        }
        composable(ROUTE_HOME) {
            HomeScreen(navController,viewModel)
        }
    }
}