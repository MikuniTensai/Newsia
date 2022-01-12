package com.mikunitensai.newsia.adapter

import android.app.Activity
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.activity.DetailActivity
import com.mikunitensai.newsia.model.News
import com.squareup.picasso.Picasso

class AdapterNews(var activity: Activity, var data:ArrayList<News>):RecyclerView.Adapter<AdapterNews.Holder>() {
    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvTitle: TextView = view.findViewById<TextView>(R.id.tv_title)
        val tvDesc: TextView = view.findViewById<TextView>(R.id.tv_desc)
        val imgImage: ImageView = view.findViewById<ImageView>(R.id.image)
        val layout: CardView = view.findViewById<CardView>(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_newnews, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvTitle.text = data[position].title.toString()
        holder.tvDesc.text = Html.fromHtml(data[position].desc.toString())
//        holder.imgImage.setImageResource(data[position].image)

        var image = "http://192.168.1.6/newsia-serverApi/public/uploads/image/"+data[position].image
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.slider1)
            .error(R.drawable.slider1)
            .into(holder.imgImage)

        holder.layout.setOnClickListener {
            val iActivity = Intent(activity, DetailActivity::class.java)

            val str = Gson().toJson(data[position], News::class.java)
            iActivity.putExtra("extra", str)
//            iActivity.putExtra("desc", data[position].title.toString())
            activity.startActivity(iActivity)
        }
    }

    override fun getItemCount(): Int {

        return data.size
    }
}