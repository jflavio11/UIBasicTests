package com.jflavio1.robolectrictest.basic

import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import com.jflavio1.robolectrictest.R
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.android.controller.ActivityController

/**
 * SecondActivityRobolectricTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
@RunWith(RobolectricTestRunner::class)
class SecondActivityRobolectricTest {

    lateinit var controller: ActivityController<SecondActivity>

    @Before
    fun setUp() {
        controller = Robolectric.buildActivity(SecondActivity::class.java)
    }

    @Test
    fun notClickListenerOnButtonTest() {
        controller.create()
        val btn: Button = controller.get().findViewById(R.id.secondActivity_btn)
        Assert.assertFalse(btn.hasOnClickListeners())
    }

    @Test
    fun setClickListenerOnBtnWhenActivityResumedTest() {
        controller.create()
        controller.start()
        controller.resume()
        val btn: Button = controller.get().findViewById(R.id.secondActivity_btn)
        Assert.assertTrue(btn.hasOnClickListeners())
    }

    @Test
    fun removeClickListenerWhenActivityPausedTest() {
        controller.create()
        controller.start()
        controller.resume()
        controller.pause()
        val btn: Button = controller.get().findViewById(R.id.secondActivity_btn)
        Assert.assertFalse(btn.hasOnClickListeners())
    }

    @Test
    fun backToMainActivityWhenBtnIsClickedTest() {
        controller.create()
        controller.start()
        controller.resume()
        val btn: Button = controller.get().findViewById(R.id.secondActivity_btn)
        btn.performClick()
        Assert.assertTrue(controller.get().isFinishing)
    }

    @Test
    fun titleStyleTest() {
        controller.create()
        val titleTv: TextView = controller.get().findViewById(R.id.secondActivity_tv_title)
        val redColorId =
            ContextCompat.getColor(RuntimeEnvironment.application, android.R.color.holo_red_dark)
        Assert.assertEquals(redColorId, titleTv.currentTextColor)
        Assert.assertEquals(22f, titleTv.textSize)
        Assert.assertEquals(20, titleTv.marginBottom)
    }

    /**
     * This test will fail since Robolectric not fully supports all UI components
     */
    @Ignore
    fun buttonSizeTest() {
        controller.create()
        val btn: Button = controller.get().findViewById(R.id.secondActivity_btn)
        Assert.assertEquals(80, btn.layoutParams.width)
        Assert.assertEquals(ConstraintLayout.LayoutParams.WRAP_CONTENT, btn.layoutParams.height)
    }

    @Test
    fun buttonStyleTest() {
        controller.create()
        val btn: Button = controller.get().findViewById(R.id.secondActivity_btn)
        Assert.assertEquals(
            R.color.colorPrimary,
            Shadows.shadowOf(btn.background).createdFromResId
        )
    }
}