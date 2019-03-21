package com.jflavio1.robolectrictest.async

import android.view.View
import android.widget.Button
import androidx.test.core.app.ActivityScenario
import com.jflavio1.robolectrictest.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLooper

/**
 * AsyncActivityTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  18/3/17
 */
@RunWith(RobolectricTestRunner::class)
class AsyncActivityTest {

    lateinit var activityScenario: ActivityScenario<AsyncActivity>

    @Before
    fun setUp() {
        activityScenario = ActivityScenario.launch(AsyncActivity::class.java)
    }

    @Test
    fun setSquareVisibleTest() {
        activityScenario.onActivity { activity ->
            val square: View = activity.findViewById(R.id.asyncActivity_square)
            val btn: Button = activity.findViewById(R.id.asyncActivity_btn)
            square.visibility = View.GONE
            btn.performClick()
            ShadowLooper.runUiThreadTasksIncludingDelayedTasks()
            Assert.assertEquals(View.VISIBLE, square.visibility)
        }
    }

    @Test
    fun setSquareInvisibleTest() {
        activityScenario.onActivity { activity ->
            val square: View = activity.findViewById(R.id.asyncActivity_square)
            val btn: Button = activity.findViewById(R.id.asyncActivity_btn)
            square.visibility = View.VISIBLE
            btn.performClick()
            ShadowLooper.runUiThreadTasksIncludingDelayedTasks()
            Assert.assertEquals(View.GONE, square.visibility)
        }
    }

}