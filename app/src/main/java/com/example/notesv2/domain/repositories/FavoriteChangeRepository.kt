package com.example.notesv2.domain.repositories

import com.example.notesv2.data.entities.Notes

interface FavoriteChangeRepository {

    fun like(notes: Notes): Int

    fun likeShow(notes: Notes): Int
}