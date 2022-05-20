package com.example.notesv2.core

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractRecyclerAdapter<T, VH : AbstractViewHolder<T>> :
    RecyclerView.Adapter<VH>(), Mapper.Unit<List<T>> {

    private val list = mutableListOf<T>()

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    override fun map(data: List<T>) {
        val diffCallback = DiffUtilCallback(list, data)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(data)
        result.dispatchUpdatesTo(this)
    }

}
