package com.main.appmycityrmv.data.model

import androidx.annotation.DrawableRes

data class Recommendation(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
    val category: Category
)
enum class Category {
    CHURCH, WEDDING, HOTEL
}
