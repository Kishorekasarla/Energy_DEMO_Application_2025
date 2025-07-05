package com.infmenergy.ui.screens.bottomnavigation.usage


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

@Composable
fun BarGraph(data: List<BarEntryData>) {
    val barEntries = data.mapIndexed { index, entry ->
        BarEntry(index.toFloat(), entry.value)
    }

    val dataSet = BarDataSet(barEntries, "Bar Data")
    dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()

    val barData = BarData(dataSet)

    val context = LocalContext.current
    val barChart = BarChart(context)
    barChart.data = barData
    barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
    barChart.xAxis.setDrawGridLines(false)

    AndroidView(
        factory = { barChart },
        modifier = Modifier.fillMaxSize()
    )
}
