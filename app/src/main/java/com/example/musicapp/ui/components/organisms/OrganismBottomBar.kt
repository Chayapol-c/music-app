package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.TextVariant
import com.example.musicapp.ui.screen.Screen

@Composable
fun OrganismBottomBar(
    currentMenu: String,
    onChangeMenu: (Screen.BottomScreen) -> Unit,
    isDisplay: Boolean,
    navigationMenuList: List<Screen.BottomScreen>
) {
    when (isDisplay) {
        true -> {
            BottomNavigation(
                modifier = Modifier.wrapContentSize()
            ) {
                navigationMenuList.forEach {menu ->
                    val tint = if (menu.bRoute == currentMenu) {
                        Color.White
                    } else {
                        Color.Black
                    }

                    BottomNavigationItem(
                        selected = menu.bRoute == currentMenu,
                        onClick = {
                            onChangeMenu.invoke(menu)
                        },
                        icon = {
                            Icon(
                                tint = tint,
                                painter = painterResource(menu.icon),
                                contentDescription = menu.title
                            )
                        },
                        label = {
                            AtomText(
                                text = menu.bTitle,
                                variant = TextVariant.LABEL,
                                style = TextStyle(color = tint)
                            )
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black,
                    )
                }
            }
        }

        false -> {

        }
    }
}