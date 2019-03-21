package com.jflavio1.robolectrictest.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import java.util.*

/**
 * SimpleService
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  18/3/17
 */
class SimpleService : Service() {

    private val random = Random()
    private val binder = LocalBinder()

    fun generateSmallRandomInt() = random.nextInt(100)

    override fun onBind(intent: Intent?) = binder

    inner class LocalBinder : Binder() {
        val service: SimpleService
            get() = this@SimpleService
    }

}