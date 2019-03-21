package com.jflavio1.robolectrictest.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jflavio1.robolectrictest.R
import kotlinx.android.synthetic.main.activity_second.*

/**
 * SecondActivity
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()
        secondActivity_btn.setOnClickListener {
            super.onBackPressed()
        }
    }

    override fun onPause() {
        super.onPause()
        secondActivity_btn.setOnClickListener(null)
    }

}