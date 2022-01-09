package com.myapp.drawersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.myapp.drawersample.ui.screen.HomeScreen
import com.myapp.drawersample.ui.theme.DrawerSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerSampleTheme {
                HomeScreen()
            }
        }
    }
}
