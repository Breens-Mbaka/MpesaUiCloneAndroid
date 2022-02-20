package com.breens.mpesaappuiclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.breens.mpesaappuiclone.databinding.FragmentHomeBinding

class FragmentHome : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val titleList = mutableListOf(
        "TOTAL SPENT THIS WEEK",
        "TOTAL SPENT THIS WEEK",
        "TOTAL SPENT THIS WEEK",
        "TOTAL SPENT THIS WEEK"
    )
    private val titleListTwo =
        mutableListOf("KSH. 1,500.00", "KSH. 1,500.00", "KSH. 1,500.00", "KSH. 1,500.00")
    private val titleListThree =
        mutableListOf("DAILY AVERAGE", "DAILY AVERAGE", "DAILY AVERAGE", "DAILY AVERAGE")
    private val titleListFour =
        mutableListOf("KSH.845.87", "KSH.845.87", "KSH.845.87", "KSH.845.87")
    private val iconsList = mutableListOf(
        R.drawable.mpesaloading,
        R.drawable.general,
        R.drawable.family,
        R.drawable.bills
    )
    private val backgroundList = mutableListOf(
        R.drawable.first_cardview_bg,
        R.drawable.second_cardview_bg,
        R.drawable.third_cardview_bg,
        R.drawable.fourth_cardview_bg
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        hideActionBar()
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        binding.viewPager.apply {
            adapter = ViewPagerAdapter(
                titleList,
                titleListTwo,
                titleListThree,
                titleListFour,
                iconsList,
                backgroundList
            )
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        val indicator = binding.indicator
        indicator.setViewPager(binding.viewPager)

    }

    private fun hideActionBar() {
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}