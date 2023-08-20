package com.maryam.footballmatches.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maryam.footballmatches.data.DataManager
import com.maryam.footballmatches.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(), MatchInteractionListener {
    private lateinit var adapter : MatchAdapter
    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        adapter = MatchAdapter(DataManager.matches, this)
        binding?.recyclerMatch?.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

    override fun bindFragments(
        inflater : LayoutInflater,
        container : ViewGroup?,
        attachToRoot : Boolean
    ) : FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun deleteItem(index : Int) {
        DataManager.deleteMatch(index)
        adapter.setData(DataManager.matches)
    }

}