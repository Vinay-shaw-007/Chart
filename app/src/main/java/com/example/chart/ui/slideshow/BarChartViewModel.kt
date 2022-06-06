package com.example.chart.ui.slideshow

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chart.R
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class BarChartViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is slideshow Fragment"
//    }
//    val text: LiveData<String> = _text
    private var _barChartData = MutableLiveData<BarData>()

    val barChartData: LiveData<BarData>
        get() = _barChartData

//    private var weekDays: ArrayList<String> = ArrayList()

    init {
        loadBarChartData()
//        setWeekDays()
    }
//    private fun setWeekDays() {
//        weekDays.add("Monday")
//        weekDays.add("Tuesday")
//        weekDays.add("Wednesday")
//        weekDays.add("Thursday")
//        weekDays.add("Friday")
//        weekDays.add("Saturday")
//        weekDays.add("Sunday")
//    }



    private fun loadBarChartData() {
        val barEntry = ArrayList<BarEntry>()
        barEntry.add(BarEntry(0F, 10000F))
        barEntry.add(BarEntry(1F, 25000F))
        barEntry.add(BarEntry(2F, 20000F))
        barEntry.add(BarEntry(3F, 30000F))
        barEntry.add(BarEntry(4F, 50000F))
        barEntry.add(BarEntry(5F, 15000F))
        barEntry.add(BarEntry(6F, 35000F))

        val colors = ArrayList<Int>()

        for (color in ColorTemplate.MATERIAL_COLORS){
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color)
        }

        val barDataSet = BarDataSet(barEntry, "Daily Sales")
//        barDataSet.colors = colors
        barDataSet.color = Color.YELLOW
//        barDataSet.valueFormatter = IndexAxisValueFormatter(weekDays)

        val barData = BarData(barDataSet)
        barData.setDrawValues(true)
        barData.setValueTextSize(15f)
        barData.setValueTextColor(Color.BLACK)
//        barData.barWidth = 0.16f
//        barData.setValueFormatter(IndexAxisValueFormatter(weekDays))
        _barChartData.value = barData

    }
}