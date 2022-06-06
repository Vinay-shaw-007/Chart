package com.example.chart.ui.home

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class PieChartViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
    private var _pieChartData = MutableLiveData<PieData>()
    val pieChartData: LiveData<PieData>
        get() = _pieChartData
    init {
        loadPieChartData()
    }

    private fun loadPieChartData() {
        val pieEntry = ArrayList<PieEntry>()
        pieEntry.add(PieEntry(0.2f, "Food and Dinning"))
        pieEntry.add(PieEntry(0.15f, "Medical"))
        pieEntry.add(PieEntry(0.10f, "Entertainment"))
        pieEntry.add(PieEntry(0.25f, "Electricity and Gas"))
        pieEntry.add(PieEntry(0.3f, "Housing"))

        val colors = ArrayList<Int>()

        for (color in ColorTemplate.MATERIAL_COLORS){
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color)
        }

        val pieDataset = PieDataSet(pieEntry, "Expense Category")
        pieDataset.colors = colors


        val pieData = PieData(pieDataset)
        pieData.setDrawValues(true)
        pieData.setValueTextSize(30f)
        pieData.setValueTextColor(Color.BLACK)

        _pieChartData.value = pieData

    }
}