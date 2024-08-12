package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.TextVariant
import com.example.musicapp.ui.screen.Screen

@Composable
fun MainDrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked: () -> Unit,
) {
    val background = if (selected) {
        Color.DarkGray
    } else {
        Color.White
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable {
                onDrawerItemClicked()
            }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            modifier = Modifier.padding(end = 8.dp, top = 4.dp)
        )
        AtomText(
            text = item.dTitle,
            variant = TextVariant.LABEL
        )
    }
}
