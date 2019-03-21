package com.jflavio1.robolectrictest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jflavio1.robolectrictest.R
import kotlinx.android.synthetic.main.fragment_item.*

/**
 * PageFragment
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  17/3/17
 */
class PageFragment : Fragment() {

    companion object {
        fun newInstance(numPage: Int) = PageFragment().apply {
            arguments = Bundle().also {
                it.putInt(ViewPagerActivity.PAGE_NUMBER, numPage)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            itemFragment_tv.text = "Current page is ${it.getInt(ViewPagerActivity.PAGE_NUMBER)}"
        }

    }

}