package com.ik.navigationjetpack.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ik.navigationjetpack.R
import com.ik.navigationjetpack.models.Movies
import kotlinx.android.synthetic.main.inflate_list.view.*
import org.jetbrains.anko.toast

 class MyAdapter(var context: Context, var list: List<Movies>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.inflate_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvName.text = "Name : " + list.get(position).original_title
        holder.tvId.text = "Id : " + list.get(position).id.toString()
        holder.tvDesc.text = "Desc : " + list.get(position).overview
        holder.tvDate.text = "Release Date : " + list.get(position).release_date

        holder.itemView.setOnClickListener {
            context.toast(list.get(position).original_title)
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvName
        val tvId = itemView.tvId
        val tvDesc = itemView.tvDesc
        val tvDate = itemView.tvDate
        val card_view = itemView.card_view
    }
}