package com.kanyideveloper.joomia.feature_wish_list.data.mapper

import com.kanyideveloper.joomia.feature_products.domain.model.Product
import com.kanyideveloper.joomia.feature_wish_list.data.local.RatingEntity
import com.kanyideveloper.joomia.feature_wish_list.data.local.WishlistEntity
import com.kanyideveloper.joomia.feature_wish_list.domain.model.Rating
import com.kanyideveloper.joomia.feature_wish_list.domain.model.Wishlist


internal fun RatingEntity.toDomain(): Rating {
    return Rating(
        count = count,
        rate = rate
    )
}

internal fun Rating.toEntity(): RatingEntity {
    return RatingEntity(
        count = count,
        rate = rate
    )
}


internal fun Rating.toProductRating(): com.kanyideveloper.joomia.feature_products.domain.model.Rating {
    return com.kanyideveloper.joomia.feature_products.domain.model.Rating(
        count = count,
        rate = rate
    )
}

internal fun com.kanyideveloper.joomia.feature_products.domain.model.Rating.toWishlistRating(): Rating {
    return Rating(
        count = count,
        rate = rate
    )
}

internal fun WishlistEntity.toDomain(): Wishlist {
    return Wishlist(
        image = image,
        price = price,
        title = title,
        id = id,
        category = category,
        description = description,
        rating = rating.toDomain(),
        liked = liked
    )
}

internal fun Wishlist.toEntity(): WishlistEntity {
    return WishlistEntity(
        image = image,
        price = price,
        title = title,
        id = id,
        category = category,
        description = description,
        rating = rating.toEntity(),
        liked = liked
    )
}

internal fun Wishlist.toProduct(): Product {
    return Product(
        image = image,
        price = price,
        title = title,
        id = id,
        category = category,
        description = description,
        rating = rating.toProductRating(),
    )
}

internal fun Product.toProduct(): Wishlist {
    return Wishlist(
        image = image,
        price = price,
        title = title,
        id = id,
        category = category,
        description = description,
        rating = rating.toWishlistRating(),
    )
}
