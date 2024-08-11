package com.example.musicapp.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _currentScreen = mutableStateOf<Screen>(Screen.DrawerScreen.AddAccount)
    val currentScreen: MutableState<Screen> = _currentScreen

    fun setCurrentScreen(screen: Screen) {
        _currentScreen.value = screen
    }
}