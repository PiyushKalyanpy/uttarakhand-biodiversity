package com.example.uttarakhandbiodiversity

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val extras = intent.extras
        val name = extras?.getString("name")
        val descp = extras?.getString("descp")
        val image = extras?.getString("image")

        val head = findViewById<TextView>(R.id.head)
        val descpc = findViewById<TextView>(R.id.descp)
        val imagec = findViewById<ImageView>(R.id.image)
        head.text = name
        descpc.text = descp

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))
        Glide.with(this)
            .load(image)
            .centerCrop()
            .apply(requestOptions)
            .into(imagec)

    }
}