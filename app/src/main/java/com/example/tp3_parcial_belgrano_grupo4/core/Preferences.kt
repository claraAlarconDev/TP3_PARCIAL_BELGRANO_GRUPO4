package com.example.tp3_parcial_belgrano_grupo4.core

import android.content.Context
import android.content.SharedPreferences

class Preferences(val context: Context) {

    private val SHARED_NAME = "myDtb"
    private val SHARED_USER_EMAIL = "userEmail"
    private val SHARED_USER_FAVOURITES_DOGS = "favorite_dogs"

    private val storage: SharedPreferences = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveEmail(email: String) {
        storage.edit().putString(SHARED_USER_EMAIL, email).apply()
    }

    fun getUserEmail(): String {
        return storage.getString(SHARED_USER_EMAIL, "")!!
    }

    fun addFavoriteDog(id: Int) {
        val set = storage.getStringSet(SHARED_USER_FAVOURITES_DOGS, emptySet())
        val mutableSet = set?.map { it.toString() }?.toMutableSet()
        if (mutableSet != null) {
            mutableSet.add(id.toString())
        }
        storage.edit().putStringSet(SHARED_USER_FAVOURITES_DOGS, mutableSet).apply()
    }

    fun removeFavoriteDog(id: Int) {
        val set = storage.getStringSet(SHARED_USER_FAVOURITES_DOGS, emptySet())
        val mutableSet = set?.map { it.toString() }?.toMutableSet()
        mutableSet?.remove(id.toString())
        storage.edit().putStringSet(SHARED_USER_FAVOURITES_DOGS, mutableSet).apply()
    }

    fun isFavoriteDog(id: Int): Boolean {
        val set = storage.getStringSet(SHARED_USER_FAVOURITES_DOGS, emptySet())
        if (set != null) {
            return set.contains(id.toString())
        }
        return false
    }
    fun getUserFavouriteDogs(): List<Int> {
        val set = storage.getStringSet(SHARED_USER_FAVOURITES_DOGS, emptySet())
        if (set != null) {
            return set.map { it.toInt() }
        }
        return emptyList()
    }

    fun wipe() {
        //borrar los datos de la bd
        storage.edit().clear().apply()
    }
}