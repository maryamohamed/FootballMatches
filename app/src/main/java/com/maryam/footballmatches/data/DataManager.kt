package com.maryam.footballmatches.data

import com.maryam.footballmatches.data.domain.Match

object DataManager {

    private val matchList = mutableListOf<Match>()
    val matches : List<Match>
        get() = matchList.toList()
    private var matchIndex = 1


    fun addMatch(match : Match) {
        matchList.add(match)
    }

    fun deleteMatch(index : Int) {
        matchList.removeAt(index)
    }

    fun getCurrentMatch() : Match = matchList[matchIndex]
    fun getNextMatch() : Match {
        matchIndex++
        if (matchIndex == matchList.size) {
            matchIndex = 0
        }
        return matchList[matchIndex]
    }

    fun getPreviousMatch() : Match {
        matchIndex--
        if (matchIndex == -1) {
            matchIndex = matchList.size - 1
        }
        return matchList[matchIndex]
    }


}