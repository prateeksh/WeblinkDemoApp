package com.example.weblinkdemoapp.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.weblinkdemoapp.R
import com.example.weblinkdemoapp.model.InfoResult

class PanelChartAdapter(private val context: Context, private val datalist: List<InfoResult>) :  RecyclerView.Adapter<PanelChartAdapter.PanelChartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelChartAdapter.PanelChartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.panel_chart, parent, false)

        return PanelChartViewHolder(view)
    }

    override fun onBindViewHolder(holder: PanelChartAdapter.PanelChartViewHolder, position: Int) {

        val name = datalist.get(position).name
        val panel = context.resources.getString(R.string.panel)

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

    inner class PanelChartViewHolder (ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val market: TextView = itemView.findViewById(R.id.panel_name)
        val container : ConstraintLayout = itemView.findViewById(R.id.panel_container)

    }
}