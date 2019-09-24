package com.ravi.enduser.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.ravi.enduser.Adapter.MyPagerAdapter
import com.ravi.enduser.R
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.side_navi_home_activity.*
import android.util.Log
import android.view.View

class Home_Activity : AppCompatActivity() {

    var floatingActionButton: FloatingActionButton?=null
    var mDoubleBackToExitPressedOnce : Boolean =false
    var tabLayout: TabLayout?=null
    var position:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        fullScreenView()

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
        tabs_main.setTabMode(TabLayout.MODE_SCROLLABLE)
        viewpager_main.setOffscreenPageLimit(5);
        // Initialize the action bar drawer toggle instance

        floatingActionButton=findViewById(R.id.add_jobsfloating)
        tabLayout=findViewById(R.id.tabs_main)
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                position = tab.position
if(position==0){
    floatingActionButton!!.show()
}else if(position==1){
    floatingActionButton!!.hide()
}
else if(position==2){
    floatingActionButton!!.hide()
}
else if(position==3){
    floatingActionButton!!.show()
}else if(position==4){
    floatingActionButton!!.hide()
}
            Log.d("tabs_Possitions",position.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })



        floatingActionButton!!.setOnClickListener{
            if(position!!.equals(0)){
            val intent= Intent(this,Create_Home_Content_Activity::class.java)
            startActivity(intent)
            } else if(position!!.equals(3)){
                val intent= Intent(this,Create_Job_Activity::class.java)
                startActivity(intent)
            }
        }
        }
    override fun onBackPressed() {

           if (viewpager_main.getCurrentItem() > 0) {
                //if any tab selected instead of tab 1
                mDoubleBackToExitPressedOnce = false
            } else if (viewpager_main.getCurrentItem() === 0) {
                //if tab 1 selected
                mDoubleBackToExitPressedOnce = true
                if (mDoubleBackToExitPressedOnce)
                    super.onBackPressed()
            }

        viewpager_main.setCurrentItem(0)//go to tab 1
    }
    fun fullScreenView(){
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onResume() {
        super.onResume()
        fullScreenView()
    }

}
