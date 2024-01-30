package com.github.alex_crookes.preferences

import android.content.SharedPreferences
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class PreferencesTests {
    private val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    private lateinit var namedPrefs: Preferences
    private lateinit var defaultPrefs: Preferences

    @Before
    fun tearUp() {
        defaultPrefs = AndroidPreferences(appContext, null)
        namedPrefs = AndroidPreferences(appContext, "test_suite")
    }

    @Test
    fun useAppContext() {
        assertEquals("com.github.alex_crookes.preferences.test", appContext.packageName)
    }

    @Test
    fun test_BooleansInDefault() {
        val sut = defaultPrefs ?: throw Exception("No test")
        assertFalse(sut.getBoolean("bool_key") ?: true)
        sut.putBoolean("bool_key", true)
        assertTrue(sut.getBoolean("bool_key") ?: false)
    }

    @Test
    fun test_BooleansInNamed() {
        val sut = namedPrefs ?: throw Exception("No Test")
        assertFalse(sut.getBoolean("bool_key") ?: true)
        sut.putBoolean("bool_key", true)
        assertTrue(sut.getBoolean("bool_key") ?: false)
    }

    @Test
    fun test_StringsInDefault() {
        val key = "test_key"
        val value = "test_value"
        val named = namedPrefs ?: throw Exception("No test")
        val default = defaultPrefs ?: throw Exception("no test")
        assertNull(named.getString(key))

        named.putString(key, value)
        assertNotNull(named.getString(key))
        assertEquals(value, named.getString(key))

        assertNull(default.getString(key))
        default.putString(key, value)
        assertEquals(value, default.getString(key))
    }

    @Test
    fun test_Remove() {
        val key = "test_removed_key"
        val named = namedPrefs ?: throw Exception("No test")
        assertNull(named.getString(key))
        named.putString(key, "test_value")
        assertNotNull(named.getString(key))

        named.remove(key)
        assertNull(named.getString(key))
    }

    @Test
    fun test_Clear() {
        val default = defaultPrefs ?: throw Exception("No test")
        val boolKey = "bool_key"
        val stringKey = "string_key"
        default.putString(stringKey, "value")
        default.putBoolean(boolKey, true)
        assertNotNull(default.getString(stringKey))
        assertNotNull(default.getBoolean(boolKey))
        assertTrue(default.getBoolean(boolKey) ?: false)
        default.clear()

        assertNull(default.getString(stringKey))
        assertFalse(default.getBoolean(boolKey) ?: true)
    }

    @Test
    fun test_TheRest() {
        val default = defaultPrefs ?: throw Exception("No test")
        val boolKey = "bool_key"
        val boolValue = true
        val stringKey = "string_key"
        val stringVal = "test_val"
        val intKey = "int_key"
        val intVale = 5
        val floatKey = "float_key"
        val floatVal = 20.4f
        val longKey = "long_key"
        val longVal = 2_000L

        default.putString(stringKey, stringVal)
        default.putBoolean(boolKey, boolValue)
        default.putInt(intKey, intVale)
        default.putFloat(floatKey, floatVal)
        default.putLong(longKey, longVal)

        assertEquals(stringVal, default.getString(stringKey))
        assertEquals(boolValue, default.getBoolean(boolKey))
        assertEquals(intVale, default.getInt(intKey, intVale + 5))
        assertEquals(floatVal, default.getFloat(floatKey, floatVal + 1.0f))
        assertEquals(longVal, default.getLong(longKey, longVal + 1L))

        default.remove(stringKey)
        default.remove(boolKey)
        default.remove(intKey)
        default.remove(floatKey)
        default.remove(longKey)

        assertNull(default.getString(stringKey))
        assertFalse(default.getBoolean(boolKey) ?: true)
        assertNotEquals(intVale, default.getInt(intKey, intVale + 5))
        assertNotEquals(floatVal, default.getFloat(floatKey, floatVal + 1.0f))
        assertNotEquals(longVal, default.getLong(longKey, longVal + 1L))
    }
}
