package com.example.musicapp.ui.theme

import androidx.annotation.DrawableRes
import com.example.musicapp.R

sealed class Screen(val title: String, val route: String) {

    sealed class DrawerScreen(val dTitle: String, val dRoute: String, @DrawableRes val icon: Int) :
        Screen(dTitle, dRoute) {
            data object Account: DrawerScreen(
                "Account",
                "account",
                R.drawable.ic_account
            )

            data object Subscription: DrawerScreen(
                "Subscription",
                "subscribe",
                R.drawable.ic_subscribe
            )

            data object AddAccount: DrawerScreen(
                "Add Account",
                "add_account",
                R.drawable.ic_baseline_person_add_alt_1_24
            )
        }
}


val screenInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.Subscription
)