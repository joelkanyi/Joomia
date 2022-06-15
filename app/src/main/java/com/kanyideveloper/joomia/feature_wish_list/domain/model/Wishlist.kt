package com.kanyideveloper.joomia.feature_wish_list.domain.model

data class Wishlist(
    val image: String,
    val price: Double,
    val title: String,
    val category: String,
    val description: String,
    val rating: Rating,
    val id: Int,
    val liked: Boolean = false,
)
