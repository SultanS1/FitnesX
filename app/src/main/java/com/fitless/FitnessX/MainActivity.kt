package com.fitless.FitnessX

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.FitnessX.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}