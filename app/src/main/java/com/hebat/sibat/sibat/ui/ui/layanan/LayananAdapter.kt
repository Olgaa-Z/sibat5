package com.hebat.sibat.sibat.ui.ui.layanan

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hebat.sibat.sibat.R
import com.hebat.sibat.sibat.ui.ui.config.Config
import kotlinx.android.synthetic.main.layanan_adapter.view.*


class LayananAdapter (private  val list:MutableList<LayananModel>, private val context: Context):
    RecyclerView.Adapter<LayananAdapter.ViewHolder>()  {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=list.get(position)
        holder.judul.text=item.judul
        holder.judul.setOnClickListener {
            val i= Intent(context, DetailLayanan::class.java)
            i.putExtra("id",item.id)
            i.putExtra("from","Layanan")
            context.startActivity(i)
        }
    }


    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): ViewHolder {
        var  v : View
        v = LayoutInflater.from(parent.context).inflate(R.layout.layanan_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){

        var judul : TextView

        init {
            judul = itemView!!.findViewById(R.id.judul)
        }

    }

}
