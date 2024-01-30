package com.github.alex_crookes.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class AndroidPreferences(
    private val context: Context, private val prefsName: String?
) : Preferences {

    private val prefs: SharedPreferences by lazy {
        prefsName?.let {
            context.getSharedPreferences(it, Context.MODE_PRIVATE )
        } ?: PreferenceManager.getDefaultSharedPreferences(context)
    }

    override fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }

    override fun clear() {
        prefs.edit().clear().apply()
    }

    override fun putBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    override fun getBoolean(key: String): Boolean {
        return prefs.getBoolean(key, false)
    }

    override fun putString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    override fun getString(key: String): String? {
        return prefs.getString(key, null)
    }

    override fun putInt(key: String, value: Int) {
        prefs.edit().putInt(key, value).apply()
    }

    override fun getInt(key: String, default: Int): Int {
        return prefs.getInt(key, default)
    }

    override fun putLong(key: String, value: Long) {
        prefs.edit().putLong(key, value).apply()
    }

    override fun getLong(key: String, default: Long): Long {
        return prefs.getLong(key, default)
    }

    override fun putFloat(key: String, value: Float) {
        prefs.edit().putFloat(key, value).apply()
    }

    override fun getFloat(key: String, default: Float): Float? {
        return prefs.getFloat(key, default)
    }

//    override fun <T : KSerializer<T>> putObject(key: String, value: T) {
//        //val serialized = Json.encodeToString()
//    }
//
//    override fun <T : KSerializer<T>> getObject(key: String): T? {
//        TODO("Not yet implemented")
//    }
}
