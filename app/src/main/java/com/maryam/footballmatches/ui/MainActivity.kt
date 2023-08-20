package com.maryam.footballmatches.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.maryam.footballmatches.data.DataManager
import com.maryam.footballmatches.databinding.ActivityMainBinding
import com.maryam.footballmatches.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myFragments = listOf<Fragment>(HomeFragment(),MatchDetailsFragment(), FilterFragment())
    private val tabTitles = listOf("Home","Details","Filter")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        parseFile()
        initPagerAdapter()
        initTab()
    }

    private fun parseFile() {
        val inputStream = assets.open("data.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val currantMatch = parser.parse(it)
            DataManager.addMatch(currantMatch)
        }
    }

    private fun initTab() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun initPagerAdapter() {
        val pagerAdapter = PagerAdapter(this, myFragments)
        binding.viewPager.adapter = pagerAdapter
    }
}