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

        val coffeeType = findViewById<TextView>(R.id.coffeeTypeResult)
        val orderName = findViewById<TextView>(R.id.orderNameResult)
        val shippingDisplay = findViewById<TextView>(R.id.shippingResult)
        val priceDisplay = findViewById<TextView>(R.id.priceResult)

        val typeText = intent.getStringExtra("coffeeType")
        val nameText = intent.getStringExtra("orderName")
        val shippingText = intent.getStringExtra("shippingType")

        orderName.text = nameText
        coffeeType.text = typeText
        shippingDisplay.text = shippingText

        val express = getString(R.string.express_shipping_2_minutes)
        val standard = getString(R.string.standard_shipping_20_minutes)
        val pickup = getString(R.string.pickup_your_order)

        if (shippingText == express) {
            priceDisplay.text = "$12.00"
        } else if (shippingText == standard) {
            priceDisplay.text = "$8.00"
        } else if (shippingText == pickup) {
            priceDisplay.text = "$5.00"
        } else {
            priceDisplay.text = "Your order type is unknown"
        }
    }
}
