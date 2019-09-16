package com.ravi.enduser.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ravi.enduser.Fragments.JobList_Activity
import com.ravi.enduser.Fragments.FirstFragment
import com.ravi.enduser.Fragments.Fragment_Your_Area
import com.ravi.enduser.Fragments.About_MLA_Fragment
import com.ravi.enduser.Fragments.News_List_Fragment


class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> About_MLA_Fragment()
            2 -> News_List_Fragment.newInstance("https://www.bhaskar.com/rss-feed/2322")
            3 -> JobList_Activity()
            4 -> Fragment_Your_Area()
            else -> {
                return FirstFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "होम"
            1 -> "आपके सांसद "
            2 -> "समाचार"
            3 -> "नौकरी"
            4 -> "आपका क्षेत्र "
            else -> {
                return "होम"
            }
        }
    }
}