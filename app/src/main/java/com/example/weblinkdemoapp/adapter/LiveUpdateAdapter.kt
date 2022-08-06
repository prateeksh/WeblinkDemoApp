package com.example.weblinkdemoapp.adapter

import android.util.Log
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
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

class LiveUpdateAdapter(private val datalist: List<InfoResult>) :  RecyclerView.Adapter<LiveUpdateAdapter.LiveUpdateViewHolder>() {

    var count: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveUpdateAdapter.LiveUpdateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.live_update, parent, false)

        Log.e("Live adapter", "onCreateViewHolder: called", )
        return LiveUpdateViewHolder(view)
    }

    override fun onBindViewHolder(holder: LiveUpdateAdapter.LiveUpdateViewHolder, position: Int) {

        val timeFormat = "HH:mm"

        val givenDateString = datalist.get(position).openOn
        val sdf = SimpleDateFormat(timeFormat)
        val d1 = sdf.parse(givenDateString)

        val h1 = d1.hours
        val m1 = d1.minutes

        val t1 = (h1 * 60) + m1

        println("hours : $h1 minutes : $m1")
        val timeStampValue = 30

        val currentTime = Calendar.getInstance().time
        val h2 = currentTime.hours
        val m2 = currentTime.minutes

        val t2 = (h2 * 60) + m2

        val diff = t2-t1

        println(" current hours : $h2 minutes : $m2")

        println("difference $diff")
        //val timeInMilliseconds = d1.time
        if (diff > 0 ) {
            if ( diff <= timeStampValue){
                holder.market.text = datalist.get(position).name
                holder.openTime.text = datalist.get(position).open
                count++
                println("count $count")
            }
        }

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class LiveUpdateViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val market: TextView = itemView.findViewById(R.id.market_name)
        val openTime: TextView = itemView.findViewById(R.id.market_open_time)

    }
}