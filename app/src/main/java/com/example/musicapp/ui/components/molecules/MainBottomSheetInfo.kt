package com.example.musicapp.ui.components.molecules

import androidx.annotation.DrawableRes
import com.example.musicapp.R

data class MainBottomSheetInfo(
    val title: String,
    @DrawableRes val icon: Int
) {
    companion object {
        val infoList = listOf(
            MainBottomSheetInfo("Setting", R.drawable.ic_setting),
            MainBottomSheetInfo("Share", R.drawable.ic_share),
            MainBottomSheetInfo("Help", R.drawable.ic_help)
        )
    }
}