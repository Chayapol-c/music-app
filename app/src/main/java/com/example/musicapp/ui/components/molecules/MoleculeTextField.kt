package com.example.musicapp.ui.components.molecules

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MoleculeTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    TextField(
        label = {
            Text(text = label)
        },
        value = value,
        onValueChange = {
            onValueChange.invoke(it)
        },
        modifier = modifier,
    )
}