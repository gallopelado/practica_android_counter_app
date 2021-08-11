package com.cursosandroidant.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cursosandroidant.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCount()

        binding.btnSum.setOnClickListener {
            count++
            setCount()
        }

        binding.btnSum.setOnLongClickListener {
            count = 0
            setCount()
            true
        }
    }

    private fun setCount() {
        binding.tvCount.text = count.toString()
    }
}