package com.fitless.fitnessX

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.FitnessX.R
import com.fitless.FitnessX.databinding.ActivityMainBinding
import com.fitless.fitnessX.application.MainApp
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding(R.id.activity_main)

    private val appNavigator by lazy { AppNavigator(this, R.id.container) }

    private val appInstance = MainApp.INSTANCE

    private val navigatorHolder = appInstance.navigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Set up the navigator
        navigatorHolder.setNavigator(appNavigator)

    }

    // You can keep onResume and onPause methods to manage the navigator holder
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(appNavigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}