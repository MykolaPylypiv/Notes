package com.example.notesv2.core

import com.example.notesv2.domain.model.Notes

interface AbstractUi {

    fun map(mapper: Mapper<Notes>): Notes

    interface Mapper<T> {

        fun map(item: Notes): T
    }
}