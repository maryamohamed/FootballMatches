package com.maryam.footballmatches.ui

import androidx.recyclerview.widget.RecyclerView
import com.maryam.footballmatches.data.domain.Match

abstract class BaseAdapter<L : List<Match>, VH : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<VH>() {
    private val items = mutableListOf<Match>()
    override fun getItemCount() : Int = items.size
    abstract fun setItems(newItems : L)

}