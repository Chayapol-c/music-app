package com.example.musicapp.ui.components.molecules

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

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
        Text(text = text)
    }
}