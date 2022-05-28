package com.example.notesv2.domain.repositories

import com.example.notesv2.core.Visibility
import com.example.notesv2.domain.model.Notes

interface EmptyVisibilityRepository {

    fun visible(list: List<Notes>): Visibility.Abstract
}