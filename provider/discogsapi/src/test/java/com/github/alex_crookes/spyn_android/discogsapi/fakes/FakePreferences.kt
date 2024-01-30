package com.github.alex_crookes.spyn_android.discogsapi.fakes

import com.github.alex_crookes.preferences.Preferences

class FakePreferences : Preferences {
    private val items = mutableMapOf<String, Any>()

    override fun remove(key: String) {
        items.remove(key)
    }

    override fun clear() {
        items.clear()
    }

    override fun putBoolean(key: String, value: Boolean) {
        items[key] = value
    }

    override fun getBoolean(key: String): Boolean {
        return items[key] as? Boolean ?: false
    }

    override fun putString(key: String, value: String) {
        items[key] = value
    }

    override fun getString(key: String): String? {
        return items[key] as? String
    }

    override fun putInt(key: String, value: Int) {
        items[key] = value
    }

    override fun getInt(key: String, default: Int): Int {
        return items[key] as? Int ?: default
    }

    override fun putLong(key: String, value: Long) {
        items[key] = value
    }

    override fun getLong(key: String, default: Long): Long {
        return items[key] as? Long ?: default
    }

    override fun putFloat(key: String, value: Float) {
        items[key] = value
    }

    override fun getFloat(key: String, default: Float): Float {
        return items[key] as? Float ?: default
    }
}
