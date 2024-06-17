package com.kanyideveloper.joomia.feature_wish_list.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.kanyideveloper.joomia.feature_wish_list.data.local.WishlistDatabase
import com.kanyideveloper.joomia.feature_wish_list.data.repository.WishlistRepositoryImpl
import com.kanyideveloper.joomia.feature_wish_list.data.util.Converters
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
    fun provideConverters(gson: Gson) = Converters(gson)

    @Provides
    @Singleton
    fun provideWishlistDatabase(
        @ApplicationContext context: Context,
        converters: Converters
    ): WishlistDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            WishlistDatabase::class.java,
            WISHLIST_DATABASE
        )
            .fallbackToDestructiveMigration()
            .addTypeConverter(converters)
            .build()
    }

    @Provides
    @Singleton
    fun provideWishlistRepository(wishlistDatabase: WishlistDatabase): WishlistRepository {
        return WishlistRepositoryImpl(wishlistDatabase.wishlistDao)
    }
}