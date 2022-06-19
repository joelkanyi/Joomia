package com.kanyideveloper.joomia.feature_wish_list.data.repository

import androidx.lifecycle.LiveData
import com.kanyideveloper.joomia.feature_wish_list.data.local.WishlistDao
import com.kanyideveloper.joomia.feature_wish_list.data.local.WishlistEntity
import com.kanyideveloper.joomia.feature_wish_list.data.mapper.toEntity
import com.kanyideveloper.joomia.feature_wish_list.domain.model.Wishlist
import com.kanyideveloper.joomia.feature_wish_list.domain.repository.WishlistRepository

class WishlistRepositoryImpl(
    private val wishlistDao: WishlistDao
) : WishlistRepository {
    override suspend fun insertToWishlist(wishlist: Wishlist) {
        wishlistDao.insertToWishlist(wishlist.toEntity())
    }

    override fun getWishlist(): LiveData<List<WishlistEntity>> {
        return wishlistDao.getWishlist()
    }

    override fun inWishlist(id: Int): LiveData<Boolean> {
        return wishlistDao.inWishlist(id)
    }

    override fun getOneWishlistItem(id: Int): LiveData<WishlistEntity?> {
        return wishlistDao.getOneWishlistItem(id)
    }

    override suspend fun deleteOneWishlist(wishlist: Wishlist) {
        wishlistDao.deleteAWishlist(wishlist.toEntity())
    }

    override suspend fun deleteAllWishlist() {
        wishlistDao.deleteAllWishlist()
    }
}