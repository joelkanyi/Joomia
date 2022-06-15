package com.kanyideveloper.joomia.feature_wish_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WishlistEntity::class], version = 1)
abstract class WishlistDatabase : RoomDatabase(){
    abstract val wishlistDao : WishlistDao
}