package com.example.campuscoffeeorder

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity" // filter in logcat to not see extra tag:MainActivity onCreate | onStart | onResume | onPause | onStop | onDestroy
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate: Activity is being created")
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val coffeeTypeET = findViewById<EditText>(R.id.coffeeType)
        val orderNameET = findViewById<EditText>(R.id.name)
        val btnSubmit = findViewById<Button>(R.id.submit)

        btnSubmit.setOnClickListener {
            val shippingGroup = findViewById<RadioGroup>(R.id.shipping)
            
            val coffeeType = coffeeTypeET.text.toString()
            val orderName = orderNameET.text.toString()
            
            if (coffeeType.isEmpty() || orderName.isEmpty() || shippingGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show() // Toast message
                return@setOnClickListener
            }
            
            val tempShippingType = shippingGroup.findViewById<RadioButton>(shippingGroup.checkedRadioButtonId)
            val shippingType = tempShippingType.text.toString()

            val intent = Intent(this@MainActivity, OrderSum::class.java)

            intent.putExtra("coffeeType", coffeeType)
            intent.putExtra("orderName", orderName)
            intent.putExtra("shippingType", shippingType)

            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity is becoming visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity is in the foreground and interactive")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity is partially obscured or losing focus")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity is no longer visible")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity is being destroyed")
    }
}
