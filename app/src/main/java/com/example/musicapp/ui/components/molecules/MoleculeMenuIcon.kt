package com.example.musicapp.ui.components.molecules

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.components.atoms.AtomText

@Composable
fun MoleculeMenuIcon(
    text: String,
    @DrawableRes icon: Int,
    iconDescription: String? = null
) {
    Row {
        Icon(
            painterResource(icon),
            contentDescription = iconDescription ?: text,
            modifier = Modifier.padding(end = 8.dp)
        )
        AtomText(text)
    }
}