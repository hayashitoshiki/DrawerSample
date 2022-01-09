package com.myapp.drawersample.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myapp.drawersample.ui.screen.Account
import com.myapp.drawersample.ui.screen.Help
import com.myapp.drawersample.ui.screen.HomeScreen

/**
 * 画面定義
 *
 * @property title
 * @property route
 */
sealed class Screens(val title: String, val route: String) {
    object Home : Screens("Home", "home")
    object Account : Screens("Account", "account")
    object Help : Screens( "Help", "help")
}

/**
 * 画面遷移定義
 *
 * @param navController
 * @param setScreen
 */
@Composable
fun AppNavHost(navController: NavHostController, setScreen: (Screens) ->Unit ) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) {
            setScreen(Screens.Home)
            HomeScreen()
        }
        composable(Screens.Account.route) {
            setScreen(Screens.Account)
            Account()
        }
        composable(Screens.Help.route) {
            setScreen(Screens.Help)
            Help()
        }
    }
}