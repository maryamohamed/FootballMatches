package com.maryam.footballmatches.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.maryam.footballmatches.R
import com.maryam.footballmatches.data.DataManager
import com.maryam.footballmatches.data.domain.Match
import com.maryam.footballmatches.databinding.FragmentMatchDetailsBinding


class MatchDetailsFragment : BaseFragment<FragmentMatchDetailsBinding>() {
    lateinit var match : Match
    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun bindFragments(
        inflater : LayoutInflater,
        container : ViewGroup?,
        attachToRoot : Boolean
    ) : FragmentMatchDetailsBinding {
        return FragmentMatchDetailsBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            icRight.setOnClickListener {
                bindMatch(DataManager.getNextMatch())
            }

            icLeft.setOnClickListener {
                bindMatch(DataManager.getPreviousMatch())
            }


        }
    }

    private fun bindMatch(match : Match) {
        binding?.apply {
            matchDate.text = match.date
            homeTeamName.text = match.homeTeamName
            awayTeamName.text = match.awayTeamName
            homeFullTimeGoals.text = match.homeTeamFullTimeGoals
            awayFullTimeGoals.text = match.awayTeamFullTimeGoals
            homeTeamHalfTimeGoals.text = match.homeTeamHalfTimeGoals
            awayTeamHalfTimeGoals.text = match.awayTeamHalfTimeGoals
            homeTeamShots.text = match.homeTeamShots
            awayTeamShots.text = match.awayTeamShots
            homeTeamCorners.text = match.homeTeamCorners
            awayTeamCorners.text = match.awayTeamCorners
            homeTeamYellowCards.text = match.homeTeamYellowCards
            awayTeamYellowCards.text = match.awayTeamYellowCards
            homeTeamRedCards.text = match.homeTeamRedCards
            awayTeamRedCards.text = match.awayTeamRedCards
            refereeName.text = match.referee
        }
    }
}


