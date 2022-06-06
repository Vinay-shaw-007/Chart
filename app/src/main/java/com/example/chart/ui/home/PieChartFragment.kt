package com.example.chart.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chart.databinding.FragmentPiechartBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.formatter.PercentFormatter

class PieChartFragment : Fragment() {

    private var _binding: FragmentPiechartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pieChartViewModel =
            ViewModelProvider(this)[PieChartViewModel::class.java]

        _binding = FragmentPiechartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupPieChart()
        pieChartViewModel.pieChartData.observe(viewLifecycleOwner, Observer {
            it.let {
                it.setValueFormatter(PercentFormatter(binding.pieChart))
                binding.pieChart.data = it
                binding.pieChart.invalidate()
                binding.pieChart.animateY(1400, Easing.EaseInOutSine)
            }
        })

        return root
    }

    private fun setupPieChart() {
        val pc = binding.pieChart
        pc.isDrawHoleEnabled = true
        pc.setUsePercentValues(true)
        pc.setEntryLabelTextSize(12F)
        pc.setEntryLabelColor(Color.BLACK)
        pc.centerText = "Spending by Category"
        pc.setCenterTextSize(24F)
        pc.description.isEnabled = false

        val l = pc.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)
        l.isEnabled = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}