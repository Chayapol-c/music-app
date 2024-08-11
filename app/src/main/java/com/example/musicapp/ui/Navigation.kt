package com.example.musicapp.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.musicapp.ui.screen.AccountView
import com.example.musicapp.ui.screen.BrowseView
import com.example.musicapp.ui.screen.HomeView
import com.example.musicapp.ui.screen.LibraryView
import com.example.musicapp.ui.screen.Screen
import com.example.musicapp.ui.screen.SubscriptionView

@Composable
fun Navigation(navController: NavController, pd: PaddingValues) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.AddAccount.route,
        modifier = Modifier.padding(pd)
    ) {
        composable(Screen.DrawerScreen.AddAccount.route) {

        }

        composable(Screen.DrawerScreen.Account.route) {
            AccountView()
        }

        composable(Screen.DrawerScreen.Subscription.route) {
            SubscriptionView()
        }

        composable(Screen.BottomScreen.Home.route) {
            HomeView()
        }

        composable(Screen.BottomScreen.Library.route) {
            LibraryView()
        }

        composable(Screen.BottomScreen.Browse.route) {
            BrowseView()
        }
    }
}