package com.kanyideveloper.joomia.di

import android.content.Context
import androidx.room.Room
import com.kanyideveloper.joomia.feature_wish_list.data.local.WishlistDatabase
import com.kanyideveloper.joomia.feature_wish_list.data.repository.WishlistRepositoryImpl
import com.kanyideveloper.joomia.feature_wish_list.domain.repository.WishlistRepository
import com.kanyideveloper.joomia.feature_wish_list.util.Constant.WISHLIST_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WishListModule {

    @Provides
    @Singleton
    fun provideWishlistDatabase(@ApplicationContext context: Context): WishlistDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            WishlistDatabase::class.java,
            WISHLIST_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideWishlistRepository(wishlistDatabase: WishlistDatabase): WishlistRepository {
        return WishlistRepositoryImpl(wishlistDatabase.wishlistDao)
    }
}