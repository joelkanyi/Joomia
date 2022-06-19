package com.kanyideveloper.joomia.feature_products.data.remote

import com.kanyideveloper.joomia.feature_products.data.remote.dto.ProductDto
import retrofit2.http.GET

interface ProductsApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductDto>

    @GET("products/categories")
    suspend fun getProductCategories(): List<String>
}