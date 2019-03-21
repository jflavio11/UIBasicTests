package com.jflavio1.robolectrictest.basic

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jflavio1.robolectrictest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivity_btn.setOnClickListener {
            if (mainActivity_pb.visibility == View.GONE) {
                mainActivity_pb.visibility = View.VISIBLE
            } else {
                mainActivity_pb.visibility = View.GONE
            }
        }

        mainActivity_btn_go.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }

}
