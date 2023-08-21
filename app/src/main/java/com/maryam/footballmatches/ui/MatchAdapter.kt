package com.maryam.footballmatches.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.maryam.footballmatches.R
import com.maryam.footballmatches.data.DataManager
import com.maryam.footballmatches.data.domain.Match
import com.maryam.footballmatches.databinding.HeaderMatchBinding
import com.maryam.footballmatches.databinding.ItemMatchBinding

class MatchAdapter(
    private var list : List<Match>,
    private val listener : MatchInteractionListener
) :
    RecyclerView.Adapter<MatchAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : BaseViewHolder {

        when (viewType) {
            ITEM_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.header_match,
                    parent,
                    false
                )
                return MatchHeaderViewHolder(view)
            }

            ITEM_MATCH -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_match,
                    parent,
                    false
                )
                return MatchViewHolder(view)
            }
        }
        return super.createViewHolder(parent, viewType)
    }


    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder : BaseViewHolder, position : Int) {
        val currentMatchItem = list[position + 1]
        val currentMatchHeader = list[position + 1]

        when (holder) {
            is MatchViewHolder -> {
                holder.binding.apply {
                    detailsHomeTeamName.text = currentMatchItem.homeTeamName
                    detailsAwayTeamName.text = currentMatchItem.awayTeamName
                    detailsHomeFullTimeGoals.text = currentMatchItem.homeTeamFullTimeGoals
                    detailsAwayFullTimeGoals.text = currentMatchItem.awayTeamFullTimeGoals
                    detailsRefereeName.text = currentMatchItem.referee
                    detailsMatchDate.text = currentMatchItem.date
//                    root.setOnClickListener {
//                        listener.replaceFragment()
//
//                    }
                }
            }

            is MatchHeaderViewHolder -> {
                holder.binding.apply {
                    detailsHomeTeamName.text = currentMatchHeader.homeTeamName
                    detailsAwayTeamName.text = currentMatchHeader.awayTeamName
                    detailsHomeFullTimeGoals.text = currentMatchHeader.homeTeamFullTimeGoals
                    detailsAwayFullTimeGoals.text = currentMatchHeader.awayTeamFullTimeGoals
                    detailsRefereeName.text = currentMatchHeader.referee
                    deleteIcon.setOnClickListener { listener.deleteItem(position) }
                }
            }
        }

    }

    fun setData(myNewList : List<Match>) {
        val diffUtil = DiffUtil.calculateDiff(MatchDiffUtil(list, myNewList))
        list = myNewList
        diffUtil.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position : Int) : Int {
        return if (position % 2 == 0) {
            ITEM_HEADER
        } else {
            ITEM_MATCH
        }
    }

    companion object {
        const val ITEM_HEADER = 0
        const val ITEM_MATCH = 1

    }


    abstract class BaseViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem)

    class MatchViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemMatchBinding.bind(viewItem)
    }

    class MatchHeaderViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = HeaderMatchBinding.bind(viewItem)
    }
}
