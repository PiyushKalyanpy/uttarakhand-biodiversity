package com.example.uttarakhandbiodiversity.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.uttarakhandbiodiversity.DetailsActivity
import com.example.uttarakhandbiodiversity.R
import com.example.uttarakhandbiodiversity.models.cardModel


class CardAdapter(private val mList: List<cardModel>, var ApplicationContext: Context) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv)
        val textView: TextView = itemView.findViewById(R.id.tv)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

        val ItemsViewModel = mList[position]
        Glide.with(ApplicationContext)
            .load(ItemsViewModel.image)
            .centerCrop()
            .apply(requestOptions)
            .into(holder.imageView)

        holder.textView.text = ItemsViewModel.name
        holder.cardView.setOnClickListener {
            val intent  = Intent(it.context, DetailsActivity::class.java)
            intent.putExtra("name", ItemsViewModel.name)
            intent.putExtra("descp", ItemsViewModel.descp)
            intent.putExtra("image", ItemsViewModel.image)
            it.context.startActivity(intent)
        }


    }
}
