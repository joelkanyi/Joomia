package com.kanyideveloper.joomia.feature_cart.domain.repository

import com.kanyideveloper.joomia.core.util.Resource
import com.kanyideveloper.joomia.feature_cart.domain.model.CartProduct
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun getAllCartItems(id: Int): Flow<Resource<List<CartProduct>>>
}