package com.maryam.footballmatches.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.maryam.footballmatches.R
import com.maryam.footballmatches.data.DataManager
import com.maryam.footballmatches.databinding.FragmentFilterBinding

class FilterFragment : BaseFragment<FragmentFilterBinding>(){
    override fun bindFragments(
        inflater : LayoutInflater,
        container : ViewGroup?,
        attachToRoot : Boolean
    ) : FragmentFilterBinding {
        return FragmentFilterBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner()
    }

    private fun initSpinner() {
        val homeTeamNames = DataManager.matches.map { it.homeTeamName }.distinct()
        val myAdapter = ArrayAdapter(
            requireContext(),
            com.maryam.footballmatches.R.layout.spinner_item,
            homeTeamNames
        )
        binding?.mySpinner?.apply {
            adapter = myAdapter
        }
    }

}