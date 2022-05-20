package com.example.notesv2.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(data: T)
}