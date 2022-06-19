package com.kanyideveloper.joomia.feature_cart.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CartProductDto(
    @SerializedName("productId")
    val productId: Int,
    @SerializedName("quantity")
    val quantity: Int
)