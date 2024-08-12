package com.example.musicapp.ui.components.molecules

import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.TextVariant

@Composable
fun MoleculeButton(
    text: String,
    onClick : () -> Unit,
) {

    TextButton(
        onClick = {
            onClick.invoke()
        }
    ) {
        AtomText(
            text = text,
            variant = TextVariant.TITLE
        )
    }
}