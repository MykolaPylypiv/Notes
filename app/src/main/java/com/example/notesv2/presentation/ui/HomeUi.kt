package com.example.notesv2.presentation.ui

import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import com.example.notesv2.core.AbstractUi
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.presentation.screens.home.HomeViewModel
import kotlinx.coroutines.Job

interface HomeUi : AbstractUi {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {

        fun map(item: Notes): T

        class Ui(
            private val widgets: Widgets,
            private val viewModel: HomeViewModel,
        ) : Mapper<Unit> {

            override fun map(item: Notes) {
                widgets.themeView.text = item.theme
                widgets.favoriteBT.setBackgroundResource(viewModel.likeShow(item))
            }
        }

        class Theme(
            private val viewModel: HomeViewModel,
        ) : Mapper<Unit> {

            override fun map(item: Notes) = viewModel.themeClick(item.uid)
        }

        class Delete(
            private val viewModel: HomeViewModel,
        ) : Mapper<Job> {

            override fun map(item: Notes) = viewModel.delete(item)
        }

        class Favorite(
            private val viewModel: HomeViewModel,
        ) : Mapper<Int> {

            override fun map(item: Notes) = viewModel.like(item)
        }
    }

    data class Widgets(
        val themeView: TextView,
        val favoriteBT: Button,
    )
}

