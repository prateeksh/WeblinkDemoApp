package com.example.weblinkdemoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weblinkdemoapp.R
import com.example.weblinkdemoapp.model.InfoResult
import java.lang.StringBuilder

class LiveResultsAdapter(private val datalist: List<InfoResult>) :  RecyclerView.Adapter<LiveResultsAdapter.LiveResultsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveResultsAdapter.LiveResultsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.live_results, parent, false)

        return LiveResultsViewHolder(view)
    }

    override fun onBindViewHolder(holder: LiveResultsAdapter.LiveResultsViewHolder, position: Int) {

        holder.name.text = datalist.get(position).name
        val open = datalist.get(position).open
        val jodi = datalist.get(position).jodi
        val close = datalist.get(position).close
        val sb = StringBuilder()
        if (close.equals(null)){
            sb.append(open).append("-").append(jodi)
        }else{
            sb.append(open).append("-").append(jodi).append("-").append(close)
        }

        holder.openInfo.text = sb.toString()

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class LiveResultsViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val name: TextView = itemView.findViewById(R.id.name)
        val openInfo: TextView = itemView.findViewById(R.id.open)


    }
}