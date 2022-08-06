package com.example.weblinkdemoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weblinkdemoapp.R
import com.example.weblinkdemoapp.Utils.NetworkUtils
import com.example.weblinkdemoapp.model.InfoResult
import java.text.SimpleDateFormat
import java.util.*

class TimeTableAdapter(private val datalist: List<InfoResult>) :  RecyclerView.Adapter<TimeTableAdapter.TimeTableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeTableAdapter.TimeTableViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.time_table, parent, false)

        return TimeTableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeTableAdapter.TimeTableViewHolder, position: Int) {

        holder.market.text = datalist.get(position).name

        holder.openTime.text =  NetworkUtils.changeTime(datalist.get(position).openOn)
        holder.closeTime.text =  NetworkUtils.changeTime(datalist.get(position).closeOn)

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class TimeTableViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val market: TextView = itemView.findViewById(R.id.market)
        val openTime: TextView = itemView.findViewById(R.id.open_time)
        val closeTime: TextView = itemView.findViewById(R.id.close_time)
    }
}