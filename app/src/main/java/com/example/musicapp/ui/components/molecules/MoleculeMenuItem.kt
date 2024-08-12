package com.example.musicapp.ui.components.molecules

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.TextVariant

@Composable
fun MoleculeMenuItem(
    label: String,
    @DrawableRes icon: Int,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AtomText(text = label, variant = TextVariant.LABEL)
        Image(painter = painterResource(icon), contentDescription = label)
    }
}