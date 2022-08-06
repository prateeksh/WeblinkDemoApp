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
import kotlin.math.min

class LiveUpdateAdapter(private val datalist: List<InfoResult>) :  RecyclerView.Adapter<LiveUpdateAdapter.LiveUpdateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveUpdateAdapter.LiveUpdateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.live_update, parent, false)

        return LiveUpdateViewHolder(view)
    }

    override fun onBindViewHolder(holder: LiveUpdateAdapter.LiveUpdateViewHolder, position: Int) {

       val givenDateString = datalist.get(position).openOn
        val sdf = SimpleDateFormat("HH:mm")
        val d1 = sdf.parse(givenDateString)


        val timeInMilliseconds = d1.time

        val timeStampValue = 1000 * 60 * 60 * 0.5

        println("given time :: $timeInMilliseconds")

        val currentTime = System.currentTimeMillis()


        println("current time :: $currentTime")

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class LiveUpdateViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val market: TextView = itemView.findViewById(R.id.market_name)
        val openTime: TextView = itemView.findViewById(R.id.market_open_time)

    }
}