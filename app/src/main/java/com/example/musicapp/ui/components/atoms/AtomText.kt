package com.example.musicapp.ui.components.atoms

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AtomText(
    text: String?,
    modifier: Modifier = Modifier,
    variant: TextVariant? = null,
    style: TextStyle? = null
) {
    text?.takeIf { it.isNotBlank() }?.let {
        val textStyle: TextStyle = when (variant) {
            TextVariant.TITLE -> {
                TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            TextVariant.DESCRIPTION -> {
                TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }

            TextVariant.LABEL -> {
                TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            null -> {
                TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Text(
            text = it,
            modifier = modifier,
            style = textStyle.merge(style)
        )
    }
}

enum class TextVariant {
    TITLE,
    DESCRIPTION,
    LABEL
}