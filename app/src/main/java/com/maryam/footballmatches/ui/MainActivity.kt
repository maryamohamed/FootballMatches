package com.maryam.footballmatches.ui

import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.maryam.footballmatches.data.DataManager
import com.maryam.footballmatches.databinding.ActivityMainBinding
import com.maryam.footballmatches.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myFragments =
        listOf<Fragment>(HomeFragment(), MatchDetailsFragment(), FilterFragment())
    private val tabTitles = listOf("Home", "Details", "Filter")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // to make transparent StatusBar
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            when (context.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_YES -> decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

                else -> decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            statusBarColor = Color.TRANSPARENT
        }

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