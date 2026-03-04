package com.example.campuscoffeeorder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val  coffeeType = findViewById<EditText>(R.id.coffeeType)
        val  orderName = findViewById<EditText>(R.id.name)


        val btnSubmit = findViewById<Button>(R.id.submit)


        btnSubmit.setOnClickListener {
            val shippingGroup = findViewById<RadioGroup>(R.id.shipping)
            val tempShippingType = shippingGroup.findViewById<RadioButton>(shippingGroup.checkedRadioButtonId)
            val coffeeType = coffeeType.text.toString()
            val orderName = orderName.text.toString()
            val shippingType = tempShippingType.text.toString()

            val intent = Intent(this@MainActivity, OrderSum::class.java)

            intent.putExtra("coffeeType", coffeeType)
            intent.putExtra("orderName", orderName)
            intent.putExtra("shippingType", shippingType)

            startActivity(intent)
        }

    }
}