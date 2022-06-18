package com.kanyideveloper.joomia.feature_cart.domain.model

data class UserCart(
    val date: String,
    val id: Int,
    val cartProducts: List<CartProduct>,
    val userId: Int,
)
