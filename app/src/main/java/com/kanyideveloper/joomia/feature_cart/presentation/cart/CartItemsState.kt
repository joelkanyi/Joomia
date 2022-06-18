package com.kanyideveloper.joomia.feature_cart.presentation.cart

import com.kanyideveloper.joomia.feature_cart.domain.model.CartProduct

data class CartItemsState(
    val cartItems: List<CartProduct> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)