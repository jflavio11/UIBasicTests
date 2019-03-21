package com.jflavio1.robolectrictest.basic

import android.widget.Button
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import com.jflavio1.robolectrictest.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * MainActivityAndroidTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
@RunWith(RobolectricTestRunner::class)
class MainActivityAndroidTest {

    lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun uiTextsTests() {
        activityScenario.onActivity { activity ->
            val tv: TextView = activity.findViewById(R.id.mainActivity_tv_title)
            val btn: Button = activity.findViewById(R.id.mainActivity_btn)
            Assert.assertEquals("Hello world!", tv.text)
            Assert.assertEquals("Touch me now", btn.text)
        }
    }

    @Test
    @Config(qualifiers = "es")
    fun uiSpanishTextsTest() {
        activityScenario.onActivity { activity ->
            val tv: TextView = activity.findViewById(R.id.mainActivity_tv_title)
            val btn: Button = activity.findViewById(R.id.mainActivity_btn)
            Assert.assertEquals("Hola mundo!", tv.text)
            Assert.assertEquals("Tócame que soy realidad", btn.text)
        }
    }

}