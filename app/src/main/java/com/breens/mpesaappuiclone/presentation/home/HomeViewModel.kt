package com.breens.mpesaappuiclone.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.breens.mpesaappuiclone.data.Statement


class HomeViewModel : ViewModel() {

    private val _statements: MutableLiveData<List<Statement>> = MutableLiveData()
    val statements: LiveData<List<Statement>>
        get() = _statements


    init {
        setUpStatement()
    }


    private fun setUpStatement(){
        val data = ArrayList<Statement>()
        data.add(
            Statement(
                "KS",
                "GROCERY",
                "122229393",
                "Ksh. 2,455.0",
                "12/01/2022",
            )
        )
        data.add(
            Statement(
                "AP",
                "AIRTIME PURCHASE",
                "1234",
                "Ksh. 12.34",
                "10/06/2022"
            )
        )
        data.add(
            Statement(
                "KS",
                "GROCERY",
                "122229393",
                "Ksh. 2,455.0",
                "12/01/2022"
            )
        )
        data.add(
            Statement(
                "AP",
                "NETFLIX",
                "1234",
                "Ksh. -12.34",
                "10/06/2022"
            )
        )
        data.add(
            Statement(
                "KS",
                "PRIME",
                "122229393",
                "Ksh. 2,455.0",
                "12/01/2022"
            )
        )
        data.add(
            Statement(
                "AP",
                "SHOWMAX",
                "1234",
                "Ksh. 12.34",
                "10/06/2022"
            )
        )
        data.add(
            Statement(
                "KS",
                "TWITCH",
                "122229393",
                "Ksh. 2,455.0",
                "12/01/2022"
            )
        )
        data.add(
            Statement(
                "AP",
                "YOUTUBE",
                "1234",
                "Ksh. -12.34",
                "10/06/2022"
            )
        )

        _statements.value = data

    }




}