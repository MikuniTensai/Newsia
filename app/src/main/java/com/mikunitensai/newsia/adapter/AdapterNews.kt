package com.mikunitensai.newsia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.model.News

class AdapterNews(var data:ArrayList<News>):RecyclerView.Adapter<AdapterNews.Holder>() {
    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvDesc = view.findViewById<TextView>(R.id.tv_desc)
        val imgImage = view.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_newnews, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvTitle.text = data[position].title.toString()
        holder.tvDesc.text = data[position].desc.toString()
        holder.imgImage.setImageResource(data[position].image)
    }

    override fun getItemCount(): Int {

        return data.size
    }
}