package com.example.chart.ui.slideshow

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chart.databinding.FragmentBarchartBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


class BarChartFragment : Fragment() {

    private var _binding: FragmentBarchartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var weekDays: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val barChartViewModel =
            ViewModelProvider(this)[BarChartViewModel::class.java]

        _binding = FragmentBarchartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setWeekDays()
//        setupBarChart()
        val xAxis = binding.barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        xAxis.valueFormatter = IndexAxisValueFormatter(weekDays)
        xAxis.setDrawGridLines(false)
        xAxis.setDrawLabels(true)
        xAxis.isGranularityEnabled = true
        xAxis.setDrawAxisLine(false)
        xAxis.granularity = 1f
        xAxis.labelCount = weekDays.size
        xAxis.labelRotationAngle = 270f
//        binding.barChart.setFitBars(true)
        binding.barChart.isDragEnabled = true
//        binding.barChart.setVisibleXRangeMaximum(3f)
        binding.barChart.axisRight.isEnabled = false
        binding.barChart.axisLeft.isEnabled = false
        barChartViewModel.barChartData.observe(viewLifecycleOwner) {
            it.let {
                binding.barChart.data = it
                binding.barChart.invalidate()
                binding.barChart.animateY(2000, Easing.EaseInOutSine)
            }
        }

        return root
    }

    private fun setupBarChart() {
        val bc = binding.barChart
        bc.description.isEnabled = false

        val l = bc.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT

        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(true)
        l.isEnabled = true
    }

    private fun setWeekDays() {
        weekDays = ArrayList()
        weekDays.add("Monday")
        weekDays.add("Tuesday")
        weekDays.add("Wednesday")
        weekDays.add("Thursday")
        weekDays.add("Friday")
        weekDays.add("Saturday")
        weekDays.add("Sunday")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}