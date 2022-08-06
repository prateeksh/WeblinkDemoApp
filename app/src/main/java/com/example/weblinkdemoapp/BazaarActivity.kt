package com.example.weblinkdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weblinkdemoapp.adapter.*
import com.example.weblinkdemoapp.databinding.ActivityMainBinding
import com.example.weblinkdemoapp.viewmodel.BazaarViewModel
import com.example.weblinkdemoapp.viewmodel.BazaarViewModelFactory
import java.util.concurrent.ForkJoinTask

class BazaarActivity : AppCompatActivity() {

    private lateinit var bazaarViewModel: BazaarViewModel

    private lateinit var liveUpdateAdapter: LiveUpdateAdapter
    private lateinit var liveUpdateRecyclerView: RecyclerView

    private lateinit var liveResultsAdapter: LiveResultsAdapter
    private lateinit var liveResultRecyclerView: RecyclerView

    private lateinit var timeTableRecyclerView: RecyclerView
    private lateinit var timeTableAdapter: TimeTableAdapter

    private lateinit var chartZoneRecyclerView: RecyclerView
    private lateinit var chartZoneAdapter: ChartZoneAdapter

    private lateinit var panelChartRecyclerView: RecyclerView
    private lateinit var panelChartAdapter: PanelChartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        liveUpdateRecyclerView = findViewById(R.id.live_update_view)
        liveResultRecyclerView = findViewById(R.id.live_results_view)
        timeTableRecyclerView = findViewById(R.id.time_table_view)
        chartZoneRecyclerView = findViewById(R.id.chart_zone_view)
        panelChartRecyclerView = findViewById(R.id.panel_chart_view)

        val repository = (application as BazaarApplication).repository

        bazaarViewModel =
            ViewModelProvider(this,
            BazaarViewModelFactory(repository)).get(BazaarViewModel::class.java)

        bazaarViewModel.user.observe(this, Observer {

            liveUpdateAdapter = LiveUpdateAdapter(bazaarViewModel.user.value!!)
            liveUpdateRecyclerView.adapter = liveUpdateAdapter
            liveUpdateRecyclerView.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)


            liveResultsAdapter = LiveResultsAdapter(bazaarViewModel.user.value!!)
            liveResultRecyclerView.adapter = liveResultsAdapter
            liveResultRecyclerView.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)


            timeTableAdapter = TimeTableAdapter(bazaarViewModel.user.value!!)
            timeTableRecyclerView.adapter = timeTableAdapter
            timeTableRecyclerView.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)

            chartZoneAdapter = ChartZoneAdapter(applicationContext, bazaarViewModel.user.value!!)
            chartZoneRecyclerView.adapter = chartZoneAdapter
            chartZoneRecyclerView.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)


            panelChartAdapter = PanelChartAdapter(applicationContext, bazaarViewModel.user.value!!)
            panelChartRecyclerView.adapter = panelChartAdapter
            panelChartRecyclerView.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        })
    }
}