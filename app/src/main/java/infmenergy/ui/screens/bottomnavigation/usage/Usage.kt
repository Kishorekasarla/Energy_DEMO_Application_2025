package com.infmenergy.ui.screens.bottomnavigation.usage

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bkvenergy.R
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.infmenergy.ui.theme.InfmEnergyTheme
import infmenergy.ui.screens.widgets.TopBar
import kotlin.math.roundToInt

data class BarChartInput(
    val value: Int,
    val day: String,
    val color: Color
)

@Composable
fun BarChart(
    data: List<BarChartInput>,
    xLabels: List<String>,
    yLabels: List<Int>,
    modifier: Modifier = Modifier
) {
    val maxBarHeight = 250.dp // Increased bar height
    val barWidth = 30.dp // Adjust bar width as needed
    val barSpacing = 0.dp // Adjust spacing between bars

    val maxValue = data.maxOf { it.value }.toFloat()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(1.dp))

        // Bars and X-axis labels
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(maxBarHeight + 30.dp) // Added space for labels below bars
        ) {
            data.forEachIndexed { index, input ->
                val barHeight = (input.value / maxValue) * maxBarHeight

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(barWidth)
                        .fillMaxHeight()
                        .padding(end = if (index < data.size - 1) barSpacing else 0.dp)
                ) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(maxBarHeight - barHeight)
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(barHeight)
                            .background(input.color)
                    )

                    Text(
                        text = xLabels[index],
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 4.dp) // Add padding for label spacing
                    )
                }
            }
        }

        // Y-axis labels
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            yLabels.reversed().forEach { yLabel ->
                Text(
                    text = yLabel.toString(),
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(maxBarHeight / yLabels.size)
                )
            }
        }
    }
}

@Composable
fun WeeklyScreen() {
    val data = listOf(
        BarChartInput(5, "Sun", color = colorResource(R.color.Theme_color)),
        BarChartInput(10, "Mon", color = colorResource(R.color.Theme_color)),
        BarChartInput(7, "Tue", color = colorResource(R.color.Theme_color)),
        BarChartInput(12, "Wed", color = colorResource(R.color.Theme_color)),
        BarChartInput(8, "Thu", color = colorResource(R.color.Theme_color)),
        BarChartInput(15, "Fri", color = colorResource(R.color.Theme_color)),
        BarChartInput(9, "Sat", color = colorResource(R.color.Theme_color))
    )

    val xLabels = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val yLabels = listOf(0, 5, 10, 15, 20) // Customize your y-axis labels here

    Spacer(modifier = Modifier.height(10.dp))

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Weekly Data",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .weight(1f) // Use weight to take available vertical space
                .fillMaxWidth()
                .background(
                    color = Color.White
                )
                .padding(20.dp), // Background color for the graph area with padding
            contentAlignment = Alignment.Center
        ) {
            BarChart(
                data = data,
                xLabels = xLabels,
                yLabels = yLabels,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}


@Composable
fun Usage(navController: NavController) {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Daily", "Weekly", "Annual")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        TopBar()

        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = colorResource(R.color.Theme_color),
        contentColor=colorResource(R.color.white),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    color = colorResource(R.color.Bkv_theme_color1)
                )
            },
            tabs = {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = { Text(title) }
                    )
                }
            }
        )
        when (tabIndex) {
            0 -> DailyScreen()
            1 -> WeeklyScreen()
            2 -> AnnualScreen()
        }
    }
}

@Composable
fun DailyScreen() {
    val data = listOf(
        BarChartInput(3, "12AM", color = colorResource(R.color.Theme_color)),
        BarChartInput(5, "4AM", color = colorResource(R.color.Theme_color)),
        BarChartInput(8, "8AM", color = colorResource(R.color.Theme_color)),
        BarChartInput(6, "12PM", color = colorResource(R.color.Theme_color)),
        BarChartInput(10, "4PM", color = colorResource(R.color.Theme_color)),
        BarChartInput(7, "8PM", color = colorResource(R.color.Theme_color)),
        BarChartInput(4, "11PM", color = colorResource(R.color.Theme_color))
    )

    val xLabels = listOf("12AM", "4AM", "8AM", "12PM", "4PM", "8PM", "11PM")
    val yLabels = listOf(0, 2, 4, 6, 8, 10) // Adjust based on max usage

    Spacer(modifier = Modifier.height(10.dp))

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Daily Data",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.White)
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            BarChart(
                data = data,
                xLabels = xLabels,
                yLabels = yLabels,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AnnualScreen() {
    val usageContainerHeight = 500.dp

    val colorPrimary = colorResource(id = R.color.Theme_color)
    val colorPink = Color(0xFFEF37A0)
    val colorNeutral02 = Color(0xFF7B797A)
    val colorNeutral01 = Color(0xFF231F20)
    val colorNeutral05 = Color(0xFFE4E4E4)
    val colorNeutral06 = Color(0xFFEDEDED)
    val colorTransparent = Color(0x00FFFFFF)

    Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = "Annual Data",
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    AndroidView(
        modifier = Modifier
            .height(usageContainerHeight)
            .fillMaxWidth(),
        factory = { context ->
            CombinedChart(context).apply {
                setDrawBorders(false)
                setDrawGridBackground(false)
                setPinchZoom(false)
                setScaleEnabled(false)

                description.text = ""

                isDoubleTapToZoomEnabled = false
                isScaleXEnabled = false
                isScaleYEnabled = false
                isDoubleTapToZoomEnabled = false
                isDragEnabled = true
                isHighlightPerDragEnabled = true
                isHighlightPerTapEnabled = true

                legend.isEnabled = false
            }
        },
        update = { chart ->

            if (chart.data != null) {
                return@AndroidView
            }

            // Raw data points
            val dataPoints = getDataPoints()

            // Usage chart data
            val usageData = BarData().apply {
                barWidth = 0.85f
            }

            val usageDataEntries: List<BarEntry> =
                dataPoints.mapIndexed { index, usageDataPoint ->
                    BarEntry(
                        index.toFloat(),
                        usageDataPoint.usage.toFloat()
                    )
                }

            Log.d("Usage", "Usage: $usageDataEntries")

            val usageDataSet = BarDataSet(usageDataEntries, "")

            usageDataSet.apply {
                setDrawValues(false)

                axisDependency = YAxis.AxisDependency.LEFT
                color = colorPrimary.toLegacyColor()
                highLightAlpha = 255 // fully opaque
                highLightColor = colorPrimary.toLegacyColor()
            }

            usageData.addDataSet(usageDataSet)

            // Average temperature chart data
            val temperatureData = LineData()
            val temperatureDataEntries: List<Entry> = emptyList()

            Log.d("Temp", "Temp: $temperatureDataEntries")

            val temperatureDataSet = LineDataSet(temperatureDataEntries, "")

            if (temperatureDataEntries.isNotEmpty()) {
                temperatureDataSet.apply {
                    setCircleColor(colorPink.toLegacyColor())
                    setDrawCircles(true)
                    setDrawHighlightIndicators(false)
                    setDrawValues(false)

                    axisDependency = YAxis.AxisDependency.RIGHT
                    circleRadius = 5f
                    circleHoleColor = colorPink.toLegacyColor()
                    color = colorPink.toLegacyColor()
                    isHighlightEnabled = false
                    lineWidth = 2.5f
                    mode = LineDataSet.Mode.LINEAR
                }

                temperatureData.addDataSet(temperatureDataSet)
            }

            // Combine Usage data & Average temperature
            val combinedData = CombinedData().apply {
                setData(usageData)
                setData(temperatureData)
            }

            val usageDataValues = usageDataEntries.map { data -> data.y }
            val usageDataMax = usageDataValues.maxOrNull() ?: GRAPH_OFFSET

            val temperatureDataValues = temperatureDataEntries.map { data -> data.y }
            val temperatureDataMax = temperatureDataValues.maxOrNull() ?: GRAPH_OFFSET

            // X axis labels
            val xAxisLabels: List<String> = dataPoints.map {
                it.month
            }

            chart.apply {

                // Set chart data
                data = combinedData

                // X Axis
                xAxis.apply {
                    setDrawGridLines(false)

                    axisLineColor = colorNeutral05.toLegacyColor()
                    axisMinimum = -(GRAPH_OFFSET)
                    axisMaximum = 12f - GRAPH_OFFSET
                    labelCount = 12
                    position = XAxis.XAxisPosition.BOTTOM
                    valueFormatter = YearAxisFormatter(xAxisLabels)
                    textColor = colorNeutral01.toLegacyColor()
                    textSize = 10f
                }

                // Y Axis(s)

                // Usage Axis
                axisLeft.apply {
                    axisMinimum = 0f
                    axisMaximum = usageDataMax + (usageDataMax * 0.2f)
                    axisLineColor = colorTransparent.toLegacyColor()
                    labelCount = 3
                    textColor = colorNeutral02.toLegacyColor()
                    textSize = 10f
                }

                // Temperature Axis
                axisRight.apply {
                    setDrawGridLines(false)

                    if (temperatureDataEntries.isEmpty()) {
                        axisMinimum = 0f
                        axisMaximum = 0f
                    } else {
                        axisMaximum = temperatureDataMax + (temperatureDataMax * 0.2f)
                    }

                    axisLineColor = colorTransparent.toLegacyColor()
                    labelCount = 3
                    textColor = colorNeutral02.toLegacyColor()
                    textSize = 12f
                }


                setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
                    override fun onValueSelected(entry: Entry?, highlight: Highlight?) {
                        Log.d("onValueSelected", "onValueSelected: $entry")

                        entry?.let {
                            //vm.selectMonth(it.x)
                        }

                        usageDataSet.color = colorNeutral05.toLegacyColor()

                        temperatureDataSet.apply {
                            setDrawCircles(false)
                            color = colorNeutral06.toLegacyColor()
                        }
                    }

                    override fun onNothingSelected() {
                        Log.d("onNothingSelected", "onNothingSelected")

                        usageDataSet.color = colorPrimary.toLegacyColor()

                        temperatureDataSet.apply {
                            setDrawCircles(true)
                            color = colorPink.toLegacyColor()
                        }

                    }
                })

            }
        }
    )

    Spacer(modifier = Modifier.height(22.dp))

    /*Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

            Box(
                modifier = Modifier
                    .padding(start = 20.dp, end = 5.dp)
                    .width(20.dp)
                    .height(9.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(MaterialTheme.colors.primaryApp)
            )

            val legendLabel = "${it.toDisplay()} " +
                    "(${vm.uiState.usageUnit?.toString().orPlaceholder()})"

            ParagraphSmall(text = legendLabel)

            Box(
                modifier = Modifier
                    .padding(start = 20.dp, end = 5.dp)
                    .width(20.dp)
                    .height(9.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(MaterialTheme.colors.secondaryPink)
            )

            ParagraphSmall(
                text = stringResource(
                    id = R.string.average_temp_legend,
                    tempLabel
                )
            )

    }*/

    Spacer(modifier = androidx.compose.ui.Modifier.height(7.dp))


}

const val GRAPH_OFFSET = 0.5f

class YearAxisFormatter(private val xAxisLabels: List<String>) : ValueFormatter() {
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        val labelIndex = (value + GRAPH_OFFSET).roundToInt()
        return if (labelIndex <= xAxisLabels.size) {
            xAxisLabels[labelIndex - 1]
        } else {
            ""
        }
    }
}

fun getDataPoints(): List<UsageDataPoint> = listOf(
    UsageDataPoint(cost = 109.206, month = "Jan", usage = 666.6660, year = "2025"),
    UsageDataPoint(cost = 99.0, month = "Feb", usage = 567.160, year = "2025"),
    UsageDataPoint(cost = 83.0, month = "Mar", usage = 448.118, year = "2025"),
    UsageDataPoint(cost = 110.116, month = "Apr", usage = 667.1364, year = "2025"),
    UsageDataPoint(cost = 120.302, month = "May", usage = 670.1202, year = "2025"),
    UsageDataPoint(cost = 77.77, month = "Jun", usage = 434.7770, year = "2025"),
    UsageDataPoint(cost = 89.206, month = "Jul", usage = 422.6660, year = "2025"),
    UsageDataPoint(cost = 0.0, month = "Aug", usage = 0.0, year = "2025"),
    UsageDataPoint(cost = 0.0, month = "Sep", usage = 0.0, year = "2025"),
    UsageDataPoint(cost = 0.0, month = "Oct", usage = 0.0, year = "2025"),
    UsageDataPoint(cost = 0.0, month = "Nov", usage = 0.0, year = "2025"),
    UsageDataPoint(cost = 0.0, month = "Dec", usage = 0.0, year = "2025")
)


data class UsageDataPoint(
    val cost: Double? = null,
    val month: String = "",
    val tempHigh: Double? = null,
    val tempLow: Double? = null,
    val unit: UsageUnit = UsageUnit.KWH,
    val usage: Double = 0.0,
    val x: Double = 0.0,
    val y: Double = usage,
    val year: String = "",
) {
    val tempAverage: Double?
        get() {
            return if (tempHigh != null && tempLow != null) {
                listOf(tempHigh, tempLow).average()
            } else {
                null
            }
        }
}

fun Color.toLegacyColor(): Int {
    return android.graphics.Color.argb(
        (alpha * 255.0f + 0.5f).toInt(),
        (red * 255.0f + 0.5f).toInt(),
        (green * 255.0f + 0.5f).toInt(),
        (blue * 255.0f + 0.5f).toInt()
    )
}

enum class UsageUnit {
    KWH,
    CCF;
}
/*{
    "monthlyDataList": [
    {
        "month": "Jan",
        "year": "2023",
        "usage": "666.6660",
        "cost": 109.206,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-01-31",
        "commodity": "Electric",
        "unitOfMeasure": "kWh"
    },
    {
        "month": "Feb",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-02-28",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Mar",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-03-31",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Apr",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-04-30",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "May",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-05-31",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Jun",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-06-30",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Jul",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-07-31",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Aug",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-08-31",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Sep",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-09-30",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Oct",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-10-31",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Nov",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-11-30",
        "commodity": "",
        "unitOfMeasure": ""
    },
    {
        "month": "Dec",
        "year": "2023",
        "usage": null,
        "cost": 0,
        "tempLow": "",
        "tempHigh": "",
        "day": null,
        "yearMonthNum": null,
        "actualDay": "2023-12-31",
        "commodity": "",
        "unitOfMeasure": ""
    }
    ],
    "year": "2023",
    "prevDataAvailable": true,
    "nextDataAvailable": false,
    "totalUsage": "666.67",
    "dataAvailable": true,
    "errorCode": "",
    "errorMessage": ""
}*/

@Preview(showBackground = true)
@Composable
fun UsagePreview() {
    InfmEnergyTheme {
        val navController = rememberNavController()
        Usage(navController)
    }
}
