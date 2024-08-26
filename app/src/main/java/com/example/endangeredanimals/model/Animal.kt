package com.example.endangeredanimals.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Animal(
   @StringRes val name: Int,
   @StringRes val description: Int,
    @DrawableRes val picture: Int,
    val link: String
)
