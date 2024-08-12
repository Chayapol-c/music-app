package com.example.musicapp.ui.components.molecules

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.TextVariant

@Composable
fun MoleculeTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    TextField(
        label = {
            AtomText(
                text = label,
                variant = TextVariant.LABEL
            )
        },
        value = value,
        onValueChange = {
            onValueChange.invoke(it)
        },
        modifier = modifier,
    )
}