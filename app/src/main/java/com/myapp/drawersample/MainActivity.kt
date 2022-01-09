package com.myapp.drawersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.myapp.drawersample.ui.AppNavHost
import com.myapp.drawersample.ui.Screens
import com.myapp.drawersample.ui.compoment.Drawer
import com.myapp.drawersample.ui.compoment.MenuButtonAppBar
import com.myapp.drawersample.ui.compoment.BackButtonAppBar
import com.myapp.drawersample.ui.theme.DrawerSampleTheme
import com.myapp.drawersample.ui.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val mainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerSampleTheme {
                AppBaseScreen(mainViewModel)
            }
        }
    }
}


/**
 * ベース画面
 *
 * @param mainViewModel
 */
@Composable
fun AppBaseScreen(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val currentScreen = mainViewModel.currentScreen.value
    // ヘッダー定義
    val topBar: @Composable () -> Unit = {
        if (currentScreen != Screens.Help) {
            MenuButtonAppBar(
                title = currentScreen.title,
                onButtonClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        } else {
            BackButtonAppBar(
                title =  currentScreen.title,
                onButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }

    // ベース画面定義
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = { topBar() },
        scaffoldState = scaffoldState,
        drawerContent = {
            Drawer { route ->
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navController.navigate(route) {
                    popUpTo = navController.graph.startDestinationId
                    launchSingleTop = true
                }
            }
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
    ) {
        // メインコンテンツ定義
        AppNavHost(navController = navController) { mainViewModel.setCurrentScreen(it) }
    }
}