package com.maryam.footballmatches.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maryam.footballmatches.R
import com.maryam.footballmatches.data.domain.Match
import com.maryam.footballmatches.databinding.ItemMatchCornersBinding
import com.maryam.footballmatches.databinding.ItemMatchFoulsBinding
import com.maryam.footballmatches.databinding.ItemMatchHalfTimeGoalsBinding
import com.maryam.footballmatches.databinding.ItemMatchRedCardsBinding
import com.maryam.footballmatches.databinding.ItemMatchShotsBinding
import com.maryam.footballmatches.databinding.ItemMatchYellowCardsBinding

class InnerAdapter(private var list : List<Match>) :
    RecyclerView.Adapter<InnerAdapter.BaseViewHolder>() {
    private val innerItems : List<Match> = list.take(6)

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : BaseViewHolder {
        when (viewType) {
            ITEM_CORNERS -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_match_corners,
                    parent,
                    false
                )
                return CornersViewHolder(view)
            }

            ITEM_FOULS -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_match_fouls,
                    parent,
                    false
                )
                return FoulsViewHolder(view)
            }

            ITEM_HALF_TIME_GOALS -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_match_half_time_goals,
                    parent,
                    false
                )
                return HalfTimeGoalsViewHolder(view)
            }

            ITEM_SHOTS -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_match_shots,
                    parent,
                    false
                )
                return ShotsViewHolder(view)
            }

            ITEM_RED_CARDS -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_match_red_cards,
                    parent,
                    false
                )
                return RedCardsViewHolder(view)
            }

            ITEM_YELLOW_CARDS -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_match_yellow_cards,
                    parent,
                    false
                )
                return YellowCardsViewHolder(view)
            }


        }
        return super.createViewHolder(parent, viewType)
    }

    override fun getItemCount() = innerItems.size

    override fun onBindViewHolder(holder : BaseViewHolder, position : Int) {
        val currentItem = list[position + 1]
        when (holder) {
            is CornersViewHolder -> {
                holder.binding.apply {
                    itemAwayTeamCorners.text = currentItem.awayTeamCorners
                    itemHomeTeamCorners.text = currentItem.homeTeamCorners
                }
            }

            is FoulsViewHolder -> {
                holder.binding.apply {
                    itemHomeTeamFouls.text = currentItem.homeTeamFouls
                    itemAwayTeamFouls.text = currentItem.awayTeamFouls
                }
            }

            is RedCardsViewHolder -> {
                holder.binding.apply {
                    itemHomeTeamRedCards.text = currentItem.homeTeamRedCards
                    itemAwayTeamRedCards.text = currentItem.awayTeamRedCards
                }
            }

            is YellowCardsViewHolder -> {
                holder.binding.apply {
                    itemHomeTeamYellowCards.text = currentItem.homeTeamYellowCards
                    itemAwayTeamYellowCards.text = currentItem.awayTeamYellowCards
                }
            }

            is ShotsViewHolder -> {
                holder.binding.apply {
                    itemHomeTeamShots.text = currentItem.homeTeamShots
                    itemAwayTeamShots.text = currentItem.awayTeamShots
                }
            }

            is HalfTimeGoalsViewHolder -> {
                holder.binding.apply {
                    itemHomeTeamHalfTimeGoals.text = currentItem.homeTeamHalfTimeGoals
                    itemAwayTeamHalfTimeGoals.text = currentItem.awayTeamHalfTimeGoals
                }
            }
        }
    }

    override fun getItemViewType(position : Int) : Int {
        when (position) {
            0 -> {
                return ITEM_FOULS
            }

            1 -> {
                return ITEM_CORNERS
            }

            2 -> {
                return ITEM_YELLOW_CARDS
            }

            3 -> {
                return ITEM_RED_CARDS
            }

            4 -> {
                return ITEM_SHOTS
            }

            5 -> {
                return ITEM_HALF_TIME_GOALS
            }

            else -> return 0
        }
    }

    abstract class BaseViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem)

    class CornersViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemMatchCornersBinding.bind(viewItem)
    }

    class FoulsViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemMatchFoulsBinding.bind(viewItem)
    }

    class HalfTimeGoalsViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemMatchHalfTimeGoalsBinding.bind(viewItem)
    }

    class ShotsViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemMatchShotsBinding.bind(viewItem)
    }

    class RedCardsViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemMatchRedCardsBinding.bind(viewItem)
    }

    class YellowCardsViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemMatchYellowCardsBinding.bind(viewItem)
    }

    companion object {
        const val ITEM_CORNERS = 0
        const val ITEM_FOULS = 1
        const val ITEM_HALF_TIME_GOALS = 2
        const val ITEM_SHOTS = 3
        const val ITEM_RED_CARDS = 4
        const val ITEM_YELLOW_CARDS = 5

    }

}