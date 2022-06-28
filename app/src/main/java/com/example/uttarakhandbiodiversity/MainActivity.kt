package com.example.uttarakhandbiodiversity

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.uttarakhandbiodiversity.adapter.CardAdapter
import com.example.uttarakhandbiodiversity.models.cardModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        Information Card -----------------------------------------
        val cardHeading = findViewById<TextView>(R.id.cardHead)
        val cardDescp = findViewById<TextView>(R.id.cardDescp)
        val cardImage = findViewById<ImageView>(R.id.cardImageInfo2)


        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                var requestOptions = RequestOptions()
                requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))
                val randomArray  = listOf<cardModel>(flora.random(), fauna.random())
                val randomItem = randomArray.random()
                cardHeading.text = randomItem.name
                cardDescp.text = randomItem.descp
                Glide.with(applicationContext)
                    .load(randomItem.image)
                    .centerCrop()
                    .apply(requestOptions)

                    .into(cardImage)
                handler.postDelayed(this, 6000)//6 sec delay
            }
        }, 0)


//        -----------------------------------------------------------


        val card = findViewById<CardView>(R.id.cardView)
        card.setOnClickListener{
            Toast.makeText(applicationContext, "Will be implemented soon ...", Toast.LENGTH_SHORT).show()
        }


        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = CardAdapter(flora, this)
        recyclerview.adapter = adapter

        val recyclerview2 = findViewById<RecyclerView>(R.id.recyclerview2)
        recyclerview2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter2 = CardAdapter(fauna, this)
        recyclerview2.adapter = adapter2
    }
}