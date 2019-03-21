package com.jflavio1.robolectrictest.basic

import android.content.Context
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.jflavio1.robolectrictest.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * SecondActivityAndroidTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
@RunWith(RobolectricTestRunner::class)
class SecondActivityAndroidTest {

    lateinit var context: Context
    lateinit var activityScenario: ActivityScenario<SecondActivity>

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        activityScenario = ActivityScenario.launch(SecondActivity::class.java)
        activityScenario.moveToState(Lifecycle.State.CREATED)
    }

    @Test
    fun notClickListenerOnButtonTest() {
        activityScenario.onActivity { activity ->
            val btn: Button = activity.findViewById(R.id.secondActivity_btn)
            Assert.assertFalse(btn.hasOnClickListeners())
        }
    }

    @Test
    fun setClickListenerOnBtnWhenActivityResumedTest() {
        activityScenario.moveToState(Lifecycle.State.RESUMED)
        activityScenario.onActivity { activity ->
            val btn: Button = activity.findViewById(R.id.secondActivity_btn)
            Assert.assertTrue(btn.hasOnClickListeners())
        }
    }

    @Test
    fun buttonSizeTest() {
        activityScenario.onActivity { activity ->
            val btn: Button = activity.findViewById(R.id.secondActivity_btn)
            Assert.assertEquals(80, btn.layoutParams.width)
            Assert.assertEquals(ConstraintLayout.LayoutParams.WRAP_CONTENT, btn.layoutParams.height)
        }

    }

}