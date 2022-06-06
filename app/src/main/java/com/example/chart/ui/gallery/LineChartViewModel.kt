package com.example.chart.ui.gallery

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate

class LineChartViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is gallery Fragment"
//    }
//    val text: LiveData<String> = _text
    private  val _lineChartData = MutableLiveData<LineData>()
    val lineChartData: LiveData<LineData>
        get() = _lineChartData
    init {
        loadLineChartData()
    }

    private fun loadLineChartData() {
        val lineEntry = ArrayList<Entry>()
        lineEntry.add(Entry(10f, 150f))
        lineEntry.add(Entry(20f, 100f))
        lineEntry.add(Entry(30f, 320f))
        lineEntry.add(Entry(40f, 250f))
        lineEntry.add(Entry(50f, 450f))
        lineEntry.add(Entry(60f, 200f))
        lineEntry.add(Entry(70f, 230f))
        lineEntry.add(Entry(80f, 413f))
        lineEntry.add(Entry(90f, 321f))
        lineEntry.add(Entry(100f, 410f))

        val colors = ArrayList<Int>()

        for (color in ColorTemplate.MATERIAL_COLORS){
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color)
        }

        val lineDataSet = LineDataSet(lineEntry, "Sales")
//        lineDataSet.colors = colors
        lineDataSet.setDrawFilled(true)
        lineDataSet.valueTextColor = Color.BLACK
        lineDataSet.valueTextSize = 12f

        val lineData = LineData(lineDataSet)

        _lineChartData.value = lineData
    }
}