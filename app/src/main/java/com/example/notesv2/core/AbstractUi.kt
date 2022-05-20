package com.example.notesv2.core

import com.example.notesv2.data.entities.Notes

interface AbstractUi {

    fun map(mapper: Mapper<Notes>): Notes

    interface Mapper<T> {

        fun map(item: Notes): T
    }
}