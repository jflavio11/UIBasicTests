package com.jflavio1.robolectrictest

import com.jflavio1.robolectrictest.services.SimpleService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ServiceController

/**
 * ServiceTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  20/3/17
 */
@RunWith(RobolectricTestRunner::class)
class ServiceTest {

    lateinit var serviceController: ServiceController<SimpleService>

    @Before
    fun setUp() {
        serviceController = Robolectric.buildService(SimpleService::class.java).bind()
    }

    @Test
    fun smallRandomIntTest() {
        Assert.assertTrue(serviceController.get().generateSmallRandomInt() < 100)
    }
}