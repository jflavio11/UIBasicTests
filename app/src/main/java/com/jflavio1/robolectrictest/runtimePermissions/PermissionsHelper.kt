package com.jflavio1.robolectrictest.runtimePermissions

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi

/**
 * PermissionsHelper
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  20/3/17
 */
@RequiresApi(Build.VERSION_CODES.M)
class PermissionsHelper {

    companion object {

        const val CAMERA_PERMISSION_REQ_CODE = 100

        /**
         * Check if the camera runtime permission is granted
         */
        fun isCameraPermissionGranted(context: Context) =
            context.checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

        /**
         * Request the camera runtime permission on the given [activity].
         */
        fun requestCameraPermission(activity: Activity) {
            activity.requestPermissions(
                arrayOf(android.Manifest.permission.CAMERA),
                CAMERA_PERMISSION_REQ_CODE
            )
        }

    }

}