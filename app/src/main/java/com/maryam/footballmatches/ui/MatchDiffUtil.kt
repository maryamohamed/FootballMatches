package com.maryam.footballmatches.ui

import androidx.recyclerview.widget.DiffUtil
import com.maryam.footballmatches.data.domain.Match

class MatchDiffUtil(private val oldList : List<Match>, private val newList : List<Match>)
    :BaseDiffUtil<Match>(oldList,newList){
    override fun checkItemsTheSame(oldItemPosition : Int, newItemPosition : Int) : Boolean {

     return (oldList[oldItemPosition].homeTeamName == newList[newItemPosition].homeTeamName
               && oldList[oldItemPosition].awayTeamName == newList[newItemPosition].awayTeamName)    }


}
