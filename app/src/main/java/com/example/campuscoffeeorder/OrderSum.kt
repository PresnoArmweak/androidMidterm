package com.example.campuscoffeeorder

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderSum : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_sum)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.orderSum)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val coffeeType = findViewById<TextView>(R.id.coffeeType)
        val orderName = findViewById<TextView>(R.id.orderName)



        val typeText = intent.getStringExtra("coffeeType")

        coffeeType.text = " $typeText"
    }
}