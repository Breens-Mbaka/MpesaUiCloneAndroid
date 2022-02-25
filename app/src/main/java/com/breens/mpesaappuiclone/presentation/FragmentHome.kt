package com.breens.mpesaappuiclone.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.breens.mpesaappuiclone.R
import com.breens.mpesaappuiclone.data.Statement
import com.breens.mpesaappuiclone.databinding.FragmentHomeBinding

class FragmentHome : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var mRecyclerview: RecyclerView

    private val titleList = mutableListOf(
        "TOTAL SPENT THIS WEEK",
        "TOTAL SPENT THIS WEEK",
        "TOTAL SPENT THIS WEEK",
        "TOTAL SPENT THIS WEEK"
    )
    private val titleListTwo =
        mutableListOf("KSH. 1,500.00", "KSH. 1,500.00", "KSH. 1,500.00", "KSH. 1,500.00")
    private val titleListThree = mutableListOf("DAILY AVERAGE", "DAILY AVERAGE", "DAILY AVERAGE", "DAILY AVERAGE")
    private val titleListFour = mutableListOf("KSH.845.87", "KSH.845.87", "KSH.845.87", "KSH.845.87")


    private val iconsList = mutableListOf(
        R.drawable.mpesaloading, R.drawable.general, R.drawable.family, R.drawable.bills
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
        initRecyclerview()
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

    private fun initRecyclerview() {
        mRecyclerview = binding.statementRecyclerview
        mRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        val data = ArrayList<Statement>()
        data.add(Statement("KS","GROCERY","122229393","Ksh. 2,455.0","12/01/2022", ))
        data.add(Statement("AP","AIRTIME PURCHASE","1234","Ksh. 12.34","10/06/2022"))
        data.add(Statement("KS","GROCERY","122229393","Ksh. 2,455.0","12/01/2022"))
        data.add(Statement("AP","NETFLIX","1234","Ksh. -12.34","10/06/2022"))
        data.add(Statement("KS","PRIME","122229393","Ksh. 2,455.0","12/01/2022"))
        data.add(Statement("AP","SHOWMAX","1234","Ksh. 12.34","10/06/2022"))
        data.add(Statement("KS","TWITCH","122229393","Ksh. 2,455.0","12/01/2022"))
        data.add(Statement("AP","YOUTUBE","1234","Ksh. -12.34","10/06/2022"))

        val adapter = StatementAdapter(data)
        mRecyclerview.adapter = adapter
    }

    private fun hideActionBar() {
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}