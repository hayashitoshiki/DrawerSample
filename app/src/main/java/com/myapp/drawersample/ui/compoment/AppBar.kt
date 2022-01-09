package com.myapp.drawersample.ui.compoment

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable

/**
 * タブトップ画面用AppBar
 *
 * @param title タイトル
 * @param onButtonClicked クリックイベント（画面遷移）
 */
@Composable
fun MenuButtonAppBar(title: String = "", onButtonClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() } ) {
                Icon(Icons.Filled.Menu, contentDescription = "")
            }
        },
        backgroundColor = androidx.compose.material.MaterialTheme.colors.primaryVariant
    )
}

/**
 * タブ２番目以降画面用Appbar
 *
 * @param title タイトル
 * @param onButtonClicked クリックイベント（戻る処理）
 */
@Composable
fun BackButtonAppBar(title: String = "", onButtonClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() } ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "")
            }
        },
        backgroundColor = androidx.compose.material.MaterialTheme.colors.primaryVariant
    )
}