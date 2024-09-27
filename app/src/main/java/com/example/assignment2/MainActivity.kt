package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val itemls = listOf(
        items("guitar",10.99f,4.5f, listOf("Classic","Acoustic"),R.drawable.guitar, true),
        items("piano",149.99f,5.0f, listOf("Electric","Table"),R.drawable.piano,true),
        items("drum",100.99f,4.8f, listOf("Electrical","Acoustic"),R.drawable.drums,true),
        items("harp",80.99f,3.5f, listOf("Classic","Acoustic"),R.drawable.harp,true),
        items("violin",10.99f,3.1f, listOf("Classic","Acoustic"),R.drawable.violin,true),
    )
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        var i=0
        setdisp(itemls[i])
        binding.next.setOnClickListener(){
            if(i+1<itemls.size){i+=1}
            setdisp(itemls[i])
        }
        binding.previous.setOnClickListener(){
            if(i-1>=0){i-=1}
            setdisp(itemls[i])
        }
        binding.borrow.setOnClickListener(){
            if (itemls[i].available){
                val intent = Intent(this, Borrow::class.java)
                intent.putExtra("chosen",itemls[i])
                startActivity(intent)
            }
        }


    }
    private fun setdisp( item:items){
        binding.name.text = item.nameval
        binding.image.setImageResource(item.imgid)
        binding.credit.text = item.credit.toString()
        binding.ratingBar2.rating = item.rate


    }
}