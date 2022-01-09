package com.myapp.drawersample.ui.compoment

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.myapp.drawersample.R
import com.myapp.drawersample.ui.Screens

/**
 * Drawableメニューリスト定義
 */
private val drawableScreens = listOf(
    Screens.Home,
    Screens.Account,
    Screens.Help
)

/**
 * Drawerメニュー定義
 *
 * @param modifier
 * @param onDestinationClicked クリックイベント(routeIdを返却)
 */
@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "App icon"
        )
        drawableScreens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable { onDestinationClicked(screen.title) }
            )
        }
    }
}
