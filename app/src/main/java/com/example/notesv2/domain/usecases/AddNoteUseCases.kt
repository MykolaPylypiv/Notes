package com.example.notesv2.domain.usecases

import android.content.Context
import com.example.notesv2.core.ChoiceStrategy
import com.example.notesv2.core.DoToast
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.data.repository.AddNotesStrategy
import com.example.notesv2.domain.entities.NotesDomain
import javax.inject.Inject

class AddNoteUseCases @Inject constructor(
    private val daoRealizationUseCases: DaoRealizationUseCases,
    private val choiceStrategy: ChoiceStrategy<Notes, AddNotesStrategy>,
    private val toast: DoToast,
) {

    fun choiceStrategy(notesDomain: NotesDomain, context: Context) {
        with(choiceStrategy) {
            if (notesDomain.theme.isNotEmpty() && notesDomain.theme.length < 24)
                if (notesDomain.content.isEmpty())
                    setEditNotes(AddNotesStrategy.ContentIsEmpty(daoRealizationUseCases))
                else
                    setEditNotes(AddNotesStrategy.ContentIsNotEmpty(daoRealizationUseCases))
            else if (notesDomain.theme.length > 24)
                setEditNotes(AddNotesStrategy.ThemeIsLong(toast))
            else if (notesDomain.theme.isEmpty())
                setEditNotes(AddNotesStrategy.ThemeIsEmpty(toast))
            else
                setEditNotes(AddNotesStrategy.ErrorUnknown(toast))

            executeStrategy(
                Notes(theme = notesDomain.theme, content = notesDomain.content), context
            )
        }
    }
}