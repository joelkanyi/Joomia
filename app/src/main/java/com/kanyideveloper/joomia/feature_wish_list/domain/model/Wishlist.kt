package com.kanyideveloper.joomia.feature_wish_list.domain.model

data class Wishlist(
    val image: String,
    val price: Double,
    val title: String,
    val liked: Boolean,
    val id: Int
)
