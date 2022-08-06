package com.example.weblinkdemoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.weblinkdemoapp.R
import com.example.weblinkdemoapp.model.InfoResult

class ChartZoneAdapter(private val context: Context, private val datalist: List<InfoResult>) :  RecyclerView.Adapter<ChartZoneAdapter.ChartZoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartZoneAdapter.ChartZoneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chart_zone, parent, false)

        return ChartZoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChartZoneAdapter.ChartZoneViewHolder, position: Int) {

        val name = datalist.get(position).name
        val panel = context.resources.getString(R.string.jodi)

        val sb = StringBuilder()
        sb.append(name).append(" ").append(panel)

        holder.market.text = sb.toString()
        if (datalist.get(position).background == "bg-yellow"){
            holder.container.setBackgroundColor(context.resources.getColor(R.color.yellow))
        }

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class ChartZoneViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val market: TextView = itemView.findViewById(R.id.chart_market)
        val container: ConstraintLayout = itemView.findViewById(R.id.chart_container)

    }
}