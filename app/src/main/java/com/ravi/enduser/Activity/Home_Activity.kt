package com.ravi.enduser.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.ravi.enduser.Adapter.MyPagerAdapter
import com.ravi.enduser.R
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.side_navi_home_activity.*


class Home_Activity : AppCompatActivity() {

    var mDoubleBackToExitPressedOnce : Boolean =false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.side_navi_home_activity)

        val menu: ImageView = findViewById(R.id.menu)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
        tabs_main.setTabMode(TabLayout.MODE_SCROLLABLE)
        viewpager_main.setOffscreenPageLimit(5);
        // Initialize the action bar drawer toggle instance
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
                this,
                drawer_layout,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }


        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        menu.setOnClickListener {
            // your code to perform when the user clicks on the button
            drawer_layout.openDrawer(GravityCompat.START)
        }
        // Close the drawer
        drawer_layout.closeDrawer(GravityCompat.START)
        true


    val navigationView: NavigationView = findViewById(R.id.nav_view)
    navigationView.setNavigationItemSelectedListener { menuItem ->
        // set item as selected to persist highlight
        menuItem.isChecked = true
        // close drawer when item is tapped
        drawer_layout.closeDrawers()

        // Handle navigation view item clicks here.
        when (menuItem.itemId) {

            R.id.action_home -> {
                Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
            }
            R.id.action_job -> {
                Toast.makeText(this, "Wallet", Toast.LENGTH_LONG).show()
            }
            R.id.action_login -> {
                var intent = Intent(this, Login_Activity::class.java)
                startActivity(intent)
            }
        }
        // Add code here to update the UI based on the item selected
        // For example, swap UI fragments here

        true
    }
}

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else {
           if (viewpager_main.getCurrentItem() > 0) {
                //if any tab selected instead of tab 1
                mDoubleBackToExitPressedOnce = false
            } else if (viewpager_main.getCurrentItem() === 0) {
                //if tab 1 selected
                mDoubleBackToExitPressedOnce = true
                if (mDoubleBackToExitPressedOnce)
                    super.onBackPressed()
            }
        }
        viewpager_main.setCurrentItem(0)//go to tab 1
    }
}
