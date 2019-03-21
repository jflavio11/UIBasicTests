package com.jflavio1.robolectrictest.runtimePermissions

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import com.jflavio1.robolectrictest.basic.MainActivity
import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowApplication

/**
 * PermissionsHelperTest
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  20/3/17
 */
@RunWith(RobolectricTestRunner::class)
class PermissionsHelperTest {

    lateinit var shadowApplication: ShadowApplication
    lateinit var activity: Activity

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java).onActivity {
            this.activity = it
            shadowApplication = Shadows.shadowOf(this.activity.application)
        }
    }

    fun checkCameraPermissionTest() {
        Assert.assertFalse(PermissionsHelper.isCameraPermissionGranted(this.activity))
        shadowApplication.grantPermissions(android.Manifest.permission.CAMERA)
        Assert.assertTrue(PermissionsHelper.isCameraPermissionGranted(this.activity))
    }

}