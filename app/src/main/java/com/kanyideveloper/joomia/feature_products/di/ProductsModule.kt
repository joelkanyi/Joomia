package com.kanyideveloper.joomia.feature_products.di

import com.kanyideveloper.joomia.core.util.Constants
import com.kanyideveloper.joomia.feature_products.data.remote.ProductsApiService
import com.kanyideveloper.joomia.feature_products.data.repository.ProductsRepositoryImpl
import com.kanyideveloper.joomia.feature_products.domain.repository.ProductsRepository
import com.kanyideveloper.joomia.feature_products.domain.use_case.GetCategoriesUseCase
import com.kanyideveloper.joomia.feature_products.domain.use_case.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsModule {

    @Provides
    @Singleton
    fun provideProductsApiService(): ProductsApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsRepository(
        productsApiService: ProductsApiService
    ): ProductsRepository {
        return ProductsRepositoryImpl(
            productsApiService
        )
    }

    @Provides
    @Singleton
    fun provideGetProductsUseCase(productsRepository: ProductsRepository): GetProductsUseCase {
        return GetProductsUseCase(productsRepository)
    }

    @Provides
    @Singleton
    fun provideGetCategoriesUseCase(productsRepository: ProductsRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(productsRepository)
    }
}