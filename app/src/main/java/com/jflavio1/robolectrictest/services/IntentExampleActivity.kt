package com.jflavio1.robolectrictest.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.jflavio1.robolectrictest.R
import com.jflavio1.robolectrictest.fragments.ViewPagerActivity
import kotlinx.android.synthetic.main.activity_intent_example.*

/**
 * IntentExampleActivity
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
class IntentExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_example)

        intent?.let {
            val i = intent.getStringExtra(ViewPagerActivity.PAGE_NUMBER)
            val text = "Button was clicked on page $i"
            intentExampleActivity_tv.text = text
        }

        intentExampleActivity_btn.setOnClickListener {
            if (bound) {
                mService.generateSmallRandomInt()
            }
        }

        bindService(
            Intent(this, SimpleService::class.java),
            serviceConnection,
            Context.BIND_AUTO_CREATE
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(serviceConnection)
    }

    private lateinit var mService: SimpleService
    private var bound = false
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            bound = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mService = (service as SimpleService.LocalBinder).service
            bound = true
        }

    }

}