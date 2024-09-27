package com.example.assignment2

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment2.databinding.ActivityMainBinding

class Borrow: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_borrow)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.borrow)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        var item = intent.getParcelableExtra<items>("chosen")
        var info = "Name:${item?.nameval},Availability:${item?.available},Credit Per month:${item?.credit},Rating:${item?.rate}"
        val confirm = findViewById<Button>(R.id.confirm)
        val cancel = findViewById<Button>(R.id.cancel)
        val text = findViewById<TextView>(R.id.textView)
        text.text = info
        val img = findViewByID<Image>(R.id.imageView)
        confirm.setOnClickListener(){
            Toast.makeText(this,"Pickup Confirmed. Please review this product",Toast.LENGTH_LONG).show()
            if (item != null) {
                item.available = false

            }



        }
        cancel.setOnClickListener(){
            Toast.makeText(this,"Successfully cancelled",Toast.LENGTH_SHORT).show()
        }

    }
}