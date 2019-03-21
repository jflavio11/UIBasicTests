package com.jflavio1.robolectrictest.async

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jflavio1.robolectrictest.R
import kotlinx.android.synthetic.main.layout_async_activity.*

/**
 * AsyncActivity
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  18/3/17
 */
class AsyncActivity : AppCompatActivity() {

    companion object {
        const val HANDLER_TIMEOUT = 5000L
    }

    val handler = Handler()
    val runnable = Runnable {
        asyncActivity_square.visibility =
            if (asyncActivity_square.visibility == View.VISIBLE) View.GONE else View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_async_activity)

        asyncActivity_btn.setOnClickListener {
            handler.postDelayed(runnable, HANDLER_TIMEOUT)
        }

    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
    }

}