package com.breens.mpesaappuiclone.data.model

import androidx.annotation.DrawableRes

data class CardInfo(
    val mainTitle:String,
    val mainAmount:String,
    val subTitle:String,
    val subAmount: String,

    @DrawableRes
    val icon:Int,

    val background:Int
)
