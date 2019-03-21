package com.jflavio1.robolectrictest.basic

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.jflavio1.robolectrictest.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config

/**
 * MainActivityRobolectricTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
@RunWith(RobolectricTestRunner::class)
class MainActivityRobolectricTest {

    lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun uiTextsTests() {
        val tv: TextView = activity.findViewById(R.id.mainActivity_tv_title)
        val btn: Button = activity.findViewById(R.id.mainActivity_btn)
        Assert.assertEquals("Hello world!", tv.text)
        Assert.assertEquals("Touch me now", btn.text)
    }

    @Test
    @Config(qualifiers = "es")
    fun uiSpanishTextsTest() {
        val tv: TextView = activity.findViewById(R.id.mainActivity_tv_title)
        val btn: Button = activity.findViewById(R.id.mainActivity_btn)
        Assert.assertEquals("Hola mundo!", tv.text)
        Assert.assertEquals("Tócame que soy realidad", btn.text)
    }

    @Test
    fun uiViewsVisibilityTests() {
        val tv: TextView = activity.findViewById(R.id.mainActivity_tv_title)
        val btn: Button = activity.findViewById(R.id.mainActivity_btn)
        val pb: ProgressBar = activity.findViewById(R.id.mainActivity_pb)
        Assert.assertEquals(View.VISIBLE, tv.visibility)
        Assert.assertEquals(View.VISIBLE, btn.visibility)
        Assert.assertEquals(View.GONE, pb.visibility)
    }

    @Test
    fun progressBarVisibilityTest() {
        val btn: Button = activity.findViewById(R.id.mainActivity_btn)
        val pb: ProgressBar = activity.findViewById(R.id.mainActivity_pb)
        Assert.assertTrue(btn.hasOnClickListeners())
        btn.performClick()
        Assert.assertEquals(View.VISIBLE, pb.visibility)
        btn.performClick()
        Assert.assertEquals(View.GONE, pb.visibility)
    }

    @Test
    fun goToSecondActivityTest() {
        val btn: Button = activity.findViewById(R.id.mainActivity_btn_go)
        btn.performClick()

        val expectedIntent = Intent(activity, SecondActivity::class.java)
        val actualIntent = Shadows.shadowOf(RuntimeEnvironment.application).nextStartedActivity
        Assert.assertEquals(expectedIntent.component, actualIntent.component)

    }
}

