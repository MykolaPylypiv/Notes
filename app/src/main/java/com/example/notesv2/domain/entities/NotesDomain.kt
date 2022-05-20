package com.example.notesv2.domain.entities

data class NotesDomain(
    val uid: Int = 0,
    var theme: String = "",
    var content: String = "",
    var isLike: Boolean = false,
)
