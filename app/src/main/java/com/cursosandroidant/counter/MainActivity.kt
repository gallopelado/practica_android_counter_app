package com.cursosandroidant.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cursosandroidant.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("Lifecycle:", "onCreate")
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

    /* Ciclo de vida, analizar*/
    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle:","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle:", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle:", "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle:","onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle:","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy")
    }

    private fun setCount() {
        binding.tvCount.text = count.toString()
    }

    // Está especializado en guardar o retener el valor, dentro de la vista
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt(Companion.PARAM_COUNT, count)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(Companion.PARAM_COUNT)
        setCount()
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        private const val PARAM_COUNT: String = "param_count"
    }

}