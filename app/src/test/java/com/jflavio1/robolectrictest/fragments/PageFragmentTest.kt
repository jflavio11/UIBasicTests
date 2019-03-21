package com.jflavio1.robolectrictest.fragments

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.core.app.ActivityScenario
import com.jflavio1.robolectrictest.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * PageFragmentTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
@RunWith(RobolectricTestRunner::class)
class PageFragmentTest {

    lateinit var fragmentScenario: FragmentScenario<PageFragment>

    @Before
    fun setUp() {
        fragmentScenario = FragmentScenario.launchInContainer(
            PageFragment::class.java,
            Bundle().also {
                it.putInt("pageNumber", 2)
            }
        )
    }

    @Test
    fun titleTextTest() {
        fragmentScenario.onFragment { f ->
            val tv: TextView = f.view?.findViewById(R.id.itemFragment_tv)!!
            Assert.assertEquals("Current page is 2", tv.text)
        }
    }
}