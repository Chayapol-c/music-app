package com.example.musicapp.ui.components.molecules

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

@Composable
fun MoleculeIconButton(
    description: String = "",
    iconVector: ImageVector? = null,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = {
            onClick.invoke()
        }
    ) {
        iconRes?.let {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = description
            )
        }
        iconVector?.let {
            Icon(
                imageVector = iconVector,
                contentDescription = description
            )
        }
    }
}