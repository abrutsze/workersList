package com.example.testapplication

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.fragment.workers.WorkersFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.rootFragment, WorkersFragment())
        fragment.commit();
    }
}