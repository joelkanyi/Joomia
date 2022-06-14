package com.kanyideveloper.joomia.feature_products.data.remote.mappers

import com.kanyideveloper.joomia.feature_products.data.remote.dto.ProductDto
import com.kanyideveloper.joomia.feature_products.data.remote.dto.RatingDto
import com.kanyideveloper.joomia.feature_products.domain.model.Product
import com.kanyideveloper.joomia.feature_products.domain.model.Rating

internal fun ProductDto.toDomain(): Product {
    return Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = ratingDto.toDomain(),
        title = title
    )
}

internal fun RatingDto.toDomain(): Rating {
    return Rating(
        count = count,
        rate = rate
    )
}