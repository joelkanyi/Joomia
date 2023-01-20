package com.kanyideveloper.joomia.feature_wish_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kanyideveloper.joomia.feature_wish_list.data.util.Converters

@TypeConverters(Converters::class)
@Database(entities = [WishlistEntity::class], version = 2, exportSchema = false)
abstract class WishlistDatabase : RoomDatabase() {
    abstract val wishlistDao: WishlistDao
}