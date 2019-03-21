package com.jflavio1.robolectrictest.fragments

import android.view.View
import android.widget.Button
import androidx.test.core.app.ActivityScenario
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jflavio1.robolectrictest.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLooper
import org.robolectric.util.Scheduler

/**
 * ViewPagerActivityTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
@Config(sdk = [27])
@RunWith(RobolectricTestRunner::class)
class ViewPagerActivityTest {

    lateinit var activityScenario: ActivityScenario<ViewPagerActivity>

    @Before
    fun setUp() {
        activityScenario = ActivityScenario.launch(ViewPagerActivity::class.java)
    }

    @Test
    fun viewPagerAttrsTest() {
        activityScenario.onActivity { activity ->
            val vp: ViewPager = activity.findViewById(R.id.viewPagerActivity_vp)
            Assert.assertNotNull(vp.adapter)
        }
    }

    @Test
    fun viewPagerButtonVisibilityTest() {
        activityScenario.onActivity { activity ->
            val vp: ViewPager = activity.findViewById(R.id.viewPagerActivity_vp)
            val btn: Button = activity.findViewById(R.id.viewPagerActivity_btn)
            RuntimeEnvironment.getMasterScheduler().idleState = Scheduler.IdleState.PAUSED
            vp.currentItem = 3
            ShadowLooper.runUiThreadTasks()
            // RuntimeEnvironment.getMasterScheduler().idleState = Scheduler.IdleState.UNPAUSED
            Assert.assertEquals(View.VISIBLE, btn.visibility)
        }
    }

    @Test
    fun viewPagerButtonNotVisibleTest() {
        activityScenario.onActivity { activity ->
            val vp: ViewPager = activity.findViewById(R.id.viewPagerActivity_vp)
            val btn: Button = activity.findViewById(R.id.viewPagerActivity_btn)
            RuntimeEnvironment.getMasterScheduler().idleState = Scheduler.IdleState.PAUSED
            vp.currentItem = 1
            ShadowLooper.runUiThreadTasks()
            // RuntimeEnvironment.getMasterScheduler().idleState = Scheduler.IdleState.UNPAUSED
            Assert.assertEquals(View.INVISIBLE, btn.visibility)
        }
    }

    @Test
    fun tabLayoutTest() {
        activityScenario.onActivity { activity ->
            val tab: TabLayout = activity.findViewById(R.id.viewPagerActivity_tab)
            Assert.assertEquals(3, tab.tabCount)
        }
    }
}