package com.kanyideveloper.joomia.feature_products.domain.model

import com.kanyideveloper.joomia.feature_products.data.remote.dto.RatingDto

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val ratingDto: RatingDto,
    val title: String
)
