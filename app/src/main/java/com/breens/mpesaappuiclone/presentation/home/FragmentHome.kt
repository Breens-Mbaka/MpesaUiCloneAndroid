package com.breens.mpesaappuiclone.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.breens.mpesaappuiclone.R
import com.breens.mpesaappuiclone.common.AppConstants.backgroundList
import com.breens.mpesaappuiclone.common.AppConstants.iconsList
import com.breens.mpesaappuiclone.common.AppConstants.titleList
import com.breens.mpesaappuiclone.common.AppConstants.titleListFour
import com.breens.mpesaappuiclone.common.AppConstants.titleListThree
import com.breens.mpesaappuiclone.common.AppConstants.titleListTwo
import com.breens.mpesaappuiclone.data.model.Statement
import com.breens.mpesaappuiclone.databinding.FragmentHomeBinding
import com.breens.mpesaappuiclone.presentation.StatementAdapter
import com.breens.mpesaappuiclone.presentation.ViewPagerAdapter

class FragmentHome : Fragment(R.layout.fragment_home) {
    private lateinit var _binding: FragmentHomeBinding
    private val binding
        get() = _binding

    //set up view model
    private val viewModel:HomeViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        hideActionBar()
        initAdapter()

    }

    //set up observers
    private fun initObservers(){
        viewModel.statements.observe(viewLifecycleOwner) { data ->
            initRecyclerview(data)
        }
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

    private fun initRecyclerview(data: List<Statement>) {
        binding.statementAdapter = StatementAdapter(data)
    }

    private fun hideActionBar() {
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

}