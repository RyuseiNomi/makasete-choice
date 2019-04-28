package com.teambrack.makasetechoice

import android.os.Bundle
import com.teambrack.makasetechoice.home.HomeFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_area, HomeFragment.newInstance(), HomeFragment.FRAGMENT_TAG)
            commit()
        }
    }
}
