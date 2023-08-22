package com.maryam.footballmatches.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maryam.footballmatches.R
import com.maryam.footballmatches.data.DataManager
import com.maryam.footballmatches.data.domain.Match
import com.maryam.footballmatches.databinding.ItemOuterMatchBinding

class OuterAdapter(private var list : List<Match>)  :
    RecyclerView.Adapter<OuterAdapter.OuterViewHolder>() {


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : OuterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_outer_match,
            parent,
            false
        )
        return OuterViewHolder(view)
    }

    override fun getItemCount() =list.size
    override fun onBindViewHolder(holder : OuterViewHolder, position : Int) {
        val current = list[position]
        val innerAdapter = InnerAdapter(DataManager.matches)
        holder.binding.apply {
            itemHomeTeamName.text = current.homeTeamName
            itemAwayTeamName.text = current.awayTeamName
            innerRecyclerView.adapter=innerAdapter
        }

    }

//    override fun setItems(newItems : List<Match>) {
//        val diffUtil = DiffUtil.calculateDiff(MatchDiffUtil(list, newItems))
//        list = newItems
//        diffUtil.dispatchUpdatesTo(this)
//    }

    class OuterViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemOuterMatchBinding.bind(viewItem)

    }


}