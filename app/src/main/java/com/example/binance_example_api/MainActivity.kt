package com.example.binance_example_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binance_example_api.databinding.MainActivityBinding
import com.example.binance_example_api.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}