package com.github.alex_crookes.preferences

import kotlinx.serialization.KSerializer

interface Preferences {
    fun remove(key: String)

    fun clear()

    fun putBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean?

    fun putString(key: String, value: String)
    fun getString(key: String): String?


    fun putInt(key: String, value: Int)
    fun getInt(key: String, default: Int): Int


    fun putLong(key: String, value: Long)
    fun getLong(key: String, default: Long): Long

    fun putFloat(key: String, value: Float)
    fun getFloat(key: String, default: Float): Float?

//    fun <T: KSerializer<T>>putObject(key: String, value: T)
//    fun <T: KSerializer<T>>getObject(key: String): T?
}
