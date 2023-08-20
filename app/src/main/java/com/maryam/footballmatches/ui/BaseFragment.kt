package com.maryam.footballmatches.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.maryam.footballmatches.data.domain.Match

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private var _binding : ViewBinding? = null
    protected open val binding get() = _binding as VB?
    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        _binding = bindFragments(inflater, container, false)
        return binding?.root
    }

    abstract fun bindFragments(
        inflater : LayoutInflater,
        container : ViewGroup?,
        attachToRoot : Boolean
    ) : VB

}