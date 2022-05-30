package com.example.notesv2.presentation.view.adapter.favorite

import com.example.notesv2.core.AbstractUi
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.presentation.model.WidgetsNotes
import com.example.notesv2.presentation.viewmodel.FavoriteViewModel
import kotlinx.coroutines.Job

interface FavoriteUi : AbstractUi {

    fun map(mapper: Mapper<Notes>): Notes

    interface Mapper<T> {

        fun map(item: Notes): T

        class Ui(
            private val widgets: WidgetsNotes,
            private val viewModel: FavoriteViewModel,
        ) : Mapper<Unit> {

            override fun map(item: Notes) {
                widgets.themeView.text = item.theme
                widgets.favoriteBT.setBackgroundResource(viewModel.likeShow(item))
            }
        }

        class Theme(
            private val viewModel: FavoriteViewModel,
        ) : Mapper<Unit> {

            override fun map(item: Notes) =
                viewModel.themeClick(item.uid)
        }

        class Delete(
            private val viewModel: FavoriteViewModel,
        ) : Mapper<Job> {

            override fun map(item: Notes) = viewModel.delete(item)
        }

        class Favorite(
            private val viewModel: FavoriteViewModel,
        ) : Mapper<Int> {

            override fun map(item: Notes) = viewModel.like(item)
        }
    }
}

