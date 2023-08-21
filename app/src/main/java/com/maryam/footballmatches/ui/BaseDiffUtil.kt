package com.maryam.footballmatches.ui
import androidx.recyclerview.widget.DiffUtil
import com.maryam.footballmatches.data.domain.Match

abstract class BaseDiffUtil <T>(
    private val oldList: List<Match>,
    private val newList: List<Match>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return checkItemsTheSame(oldItemPosition,newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }

    abstract fun checkItemsTheSame(oldItemPosition : Int, newItemPosition : Int): Boolean

}