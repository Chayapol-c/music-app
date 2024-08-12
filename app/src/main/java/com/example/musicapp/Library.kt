package com.example.musicapp

import androidx.annotation.DrawableRes

data class Library(
    @DrawableRes val icon: Int,
    val name: String,
    val onClickMenu: () -> Unit
)

val libraries = listOf(
    Library(R.drawable.ic_playlist, "Playlist", {}),
    Library(R.drawable.ic_artists, "Artist", {}),
    Library(R.drawable.ic_album, "Album", {}),
    Library(R.drawable.ic_song, "Song", {}),
    Library(R.drawable.ic_genre, "Genre", {}),
)
