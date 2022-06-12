package com.kanyideveloper.joomia.feature_products.data.remote.mappers

import com.kanyideveloper.joomia.feature_products.data.remote.dto.ProductDto
import com.kanyideveloper.joomia.feature_products.domain.model.Product

internal fun ProductDto.toDomain(): Product {
    return Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        ratingDto = ratingDto,
        title = title
    )
}