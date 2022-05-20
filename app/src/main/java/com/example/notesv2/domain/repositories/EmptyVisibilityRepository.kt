package com.example.notesv2.domain.repositories

import com.example.notesv2.core.Visibility
import com.example.notesv2.data.entities.Notes

interface EmptyVisibilityRepository {

    fun visible(list: List<Notes>): Visibility.Abstract
}