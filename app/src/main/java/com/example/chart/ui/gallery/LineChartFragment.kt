package com.example.chart.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chart.databinding.FragmentLinechartBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis

class LineChartFragment : Fragment() {

    private var _binding: FragmentLinechartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val lineChartViewModel =
            ViewModelProvider(this)[LineChartViewModel::class.java]

        _binding = FragmentLinechartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.lineChart.axisRight.isEnabled = false
        binding.lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChartViewModel.lineChartData.observe(viewLifecycleOwner) {
            it.let {
                binding.lineChart.data = it
                binding.lineChart.invalidate()
                binding.lineChart.animateY(2000, Easing.EaseInOutSine)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}