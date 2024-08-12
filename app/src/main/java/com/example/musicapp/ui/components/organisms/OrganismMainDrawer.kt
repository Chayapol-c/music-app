package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.components.molecules.MainDrawerItem
import com.example.musicapp.ui.screen.Screen

@Composable
fun OrganismMainDrawer(
    currentRoute: String,
    menuList: List<Screen.DrawerScreen>,
    onMenuItemClick: (Screen.DrawerScreen) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(menuList) { menu ->
            MainDrawerItem(
                selected = menu.route == currentRoute,
                item = menu,
                onDrawerItemClicked = {
                    onMenuItemClick.invoke(menu)
                })
        }
    }
}