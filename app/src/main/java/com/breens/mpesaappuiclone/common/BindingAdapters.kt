package com.breens.mpesaappuiclone.common

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import coil.load
import io.getstream.avatarview.AvatarView

@BindingAdapter("cardIcon")
fun setUpCardIcon(imageView: ImageView, @DrawableRes icon:Int){
    imageView.load(icon){
        crossfade(true)
    }
}

@BindingAdapter("myCardBackground")
fun setUpCardBG(layout:ConstraintLayout, bg:Int){
    layout.setBackgroundResource(bg)
}

@BindingAdapter("statementInitials")
fun setUpInitials(avatarView: AvatarView, initials:String){
    avatarView.avatarInitials = initials
}