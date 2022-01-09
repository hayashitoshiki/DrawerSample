package com.myapp.drawersample.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.myapp.drawersample.ui.Screens

class MainViewModel : ViewModel() {
    private val _currentScreen = mutableStateOf<Screens>(Screens.Home)
    val currentScreen: State<Screens> = _currentScreen

    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
    }

}