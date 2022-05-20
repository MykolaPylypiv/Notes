package com.example.notesv2.data.repository

import android.content.Context
import android.widget.Toast
import com.example.notesv2.R
import com.example.notesv2.core.DoToast
import com.example.notesv2.core.Strategy
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.usecases.DaoRealizationUseCases

interface AddNotesStrategy : Strategy<Notes> {

    class ThemeIsEmpty(private val toast: DoToast) : AddNotesStrategy {
        override fun execute(item: Notes, context: Context?) =
            toast.doToast(context, THEME_IS_EMPTY, Toast.LENGTH_LONG)
    }

    class ThemeIsLong(private val toast: DoToast) : AddNotesStrategy {
        override fun execute(item: Notes, context: Context?) =
            toast.doToast(context, LONG_THEME, Toast.LENGTH_LONG)
    }

    class ContextIsNull : AddNotesStrategy {
        override fun execute(item: Notes, context: Context?) =
            throw IllegalArgumentException(ERROR_NULL_CONTEXT)
    }

    class ContentIsEmpty(private val daoRealizationUseCases: DaoRealizationUseCases) :
        AddNotesStrategy {
        override fun execute(item: Notes, context: Context?) =
            daoRealizationUseCases.insert(item)
    }

    class ContentIsNotEmpty(private val daoRealizationUseCases: DaoRealizationUseCases) :
        AddNotesStrategy {
        override fun execute(item: Notes, context: Context?) =
            daoRealizationUseCases.insert(item)
    }

    class ErrorUnknown(private val toast: DoToast) : AddNotesStrategy {
        override fun execute(item: Notes, context: Context?) =
            toast.doToast(context, ERROR_UNKNOWN, Toast.LENGTH_SHORT)
    }

    companion object {
        const val LONG_THEME = R.string.long_theme
        const val THEME_IS_EMPTY = R.string.theme_is_empty
        const val ERROR_UNKNOWN = R.string.error_unknown
        const val ERROR_NULL_CONTEXT = "Context equal null"
    }

}

