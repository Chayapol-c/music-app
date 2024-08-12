package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.musicapp.ui.components.atoms.AtomText
import com.example.musicapp.ui.components.atoms.AtomTextFieldGroup
import com.example.musicapp.ui.components.atoms.TextVariant
import com.example.musicapp.ui.components.molecules.MoleculeButton
import com.example.musicapp.ui.components.molecules.MoleculeTextField

@Composable
fun OrganismAccountDialog(dialogOpen: MutableState<Boolean>) {
    if (dialogOpen.value) {
        AlertDialog(
            title = {
                AtomText(text = "Add Account", variant = TextVariant.TITLE)
            },
            text = {
                AtomTextFieldGroup {
                    MoleculeTextField(
                        label = "Email",
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.padding(16.dp)
                    )
                    MoleculeTextField(
                        label = "Password",
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.padding(16.dp)
                    )
                }
            },
            onDismissRequest = {
                dialogOpen.value = false
            },
            confirmButton = {
                MoleculeButton(
                    text = "Confirm",
                    onClick = {
                        dialogOpen.value = false
                    }
                )
            },
            dismissButton = {
                MoleculeButton(
                    text = "Dismiss",
                    onClick = {
                        dialogOpen.value = false
                    }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primarySurface),
            shape = RoundedCornerShape(5.dp),
            backgroundColor = Color.White,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
}