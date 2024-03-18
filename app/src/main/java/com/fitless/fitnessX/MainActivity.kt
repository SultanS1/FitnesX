package com.fitless.fitnessX

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.FitnessX.R
import com.fitless.FitnessX.databinding.ActivityMainBinding
import com.fitless.fitnessX.router.AppRouter
import com.fitless.fitnessX.screen.Screens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding(R.id.rootId)
    private lateinit var router: Router
    private lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Cicerone
        val cicerone = Cicerone.create()
        router = cicerone.router
        navigatorHolder = cicerone.getNavigatorHolder()

        // Set up the navigator
        val navigator = AppNavigator(this, R.id.container) // Assuming a container view with id container
        navigatorHolder.setNavigator(navigator)

        // Start with the initial screen
        router.replaceScreen(Screens.WelcomeScreen())
    }

    // You can keep onResume and onPause methods to manage the navigator holder
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(AppNavigator(this, R.id.container))
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}