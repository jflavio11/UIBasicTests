package com.jflavio1.robolectrictest.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * ViewPagerAdapter
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    companion object {
        const val NUM_PAGES = 3;
    }

    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(position)
    }

    override fun getCount() = NUM_PAGES

}