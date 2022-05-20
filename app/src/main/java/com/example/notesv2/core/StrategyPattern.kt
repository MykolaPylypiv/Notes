package com.example.notesv2.core

import android.content.Context

interface ChoiceStrategy<E, T : Strategy<E>> {

    fun setEditNotes(strategy: T)

    fun executeStrategy(item: E, context: Context): Any

    class Base<E, T : Strategy<E>> : ChoiceStrategy<E, T> {
        private lateinit var editNotes: T

        override fun setEditNotes(strategy: T) {
            this.editNotes = strategy
        }

        override fun executeStrategy(item: E, context: Context) =
            editNotes.execute(item, context)
    }
}

interface Strategy<E> {

    fun execute(item: E, context: Context?): Any
}

