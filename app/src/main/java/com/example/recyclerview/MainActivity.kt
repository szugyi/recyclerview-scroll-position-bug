package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.list)?.apply {
            adapter = TestAdapter().apply {
                submitList(
                    (1..100)
                        .map { it.toString() }
                        .toList()
                )
            }
        }

        lifecycleScope.launch {
            repeat(100) {
                delay(500)
                recyclerView?.requestLayout()
            }
        }
    }
}