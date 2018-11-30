package com.neadev.framentlife

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var fragmentState = 0
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.changeFragmentBtn)
        btn.setOnClickListener {
            when(fragmentState) {
                0 -> changeFragment(FragmentOne())
                1 -> changeFragment(FragmentTwo())
                else -> changeFragment(FragmentOne())
            }
        }
    }

    fun changeFragment(fragment: Fragment) {
        fragmentState = if(fragmentState == 0) 1 else 0
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragmentHolder, fragment)
        transaction.commit()

    }
}