package com.example.musicapp.ui.screen.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.musicapp.ui.screen.Screen

class MainViewModel : ViewModel() {

    private val _currentScreen = mutableStateOf<Screen>(Screen.DrawerScreen.AddAccount)
    val currentScreen: MutableState<Screen> = _currentScreen

    fun setCurrentScreen(screen: Screen) {
        _currentScreen.value = screen
    }
}