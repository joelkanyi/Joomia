package com.kanyideveloper.joomia.feature_wish_list.data.mapper

import com.kanyideveloper.joomia.feature_wish_list.data.local.WishlistEntity
import com.kanyideveloper.joomia.feature_wish_list.domain.model.Wishlist

internal fun WishlistEntity.toDomain(): Wishlist {
    return Wishlist(
        image = image,
        price = price,
        title = title,
        id = id,
        liked = liked
    )
}

internal fun Wishlist.toEntity(): WishlistEntity {
    return WishlistEntity(
        image = image,
        price = price,
        title = title,
        id = id,
        liked = liked
    )
}
