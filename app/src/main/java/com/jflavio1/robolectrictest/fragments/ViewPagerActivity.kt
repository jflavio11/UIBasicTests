package com.jflavio1.robolectrictest.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.jflavio1.robolectrictest.R
import com.jflavio1.robolectrictest.services.IntentExampleActivity
import kotlinx.android.synthetic.main.activity_view_pager.*

/**
 * ViewPagerActivity
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
class ViewPagerActivity : AppCompatActivity() {

    companion object {
        const val PAGE_NUMBER = "pageNumber"
    }

    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        adapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerActivity_vp.let {
            it.currentItem = 0
            it.adapter = adapter
        }

        viewPagerActivity_tab.setupWithViewPager(viewPagerActivity_vp)

        viewPagerActivity_btn.setOnClickListener {
            val i = Intent(this, IntentExampleActivity::class.java)
                .putExtra(PAGE_NUMBER, viewPagerActivity_vp.currentItem)
            startActivity(i)
        }

        viewPagerActivity_vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                if (position == ViewPagerAdapter.NUM_PAGES - 1) {
                    viewPagerActivity_btn.alpha = 1 - positionOffset
                } else {
                    viewPagerActivity_btn.alpha = positionOffset
                }

            }

            override fun onPageSelected(position: Int) {
                viewPagerActivity_btn.visibility =
                    if (position == (ViewPagerAdapter.NUM_PAGES - 1)) View.VISIBLE else View.INVISIBLE
            }

        })

    }

}