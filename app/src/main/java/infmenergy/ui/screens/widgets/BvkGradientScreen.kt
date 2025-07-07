import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun VibrantGradientBackground() {
    val gradientColors = listOf(
        Color(0xFF4A93FF), // blue
        Color(0xFF00B9FE), // cyan
        Color(0xFF00DBEC), // aqua
        Color(0xFF00F4CD), // light teal
        Color(0xFF00FFA4), // mint
        Color(0xFF00FF75), // neon green
        Color(0xFFABFF41), // lime green
        Color(0xFFFFEE00)  // yellow
    )

    val gradient = Brush.linearGradient(
        colors = gradientColors,
        start = Offset(0f, Float.POSITIVE_INFINITY), // bottom-left
        end = Offset(Float.POSITIVE_INFINITY, 0f)     // top-right (285° approx)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewVibrantGradientBackground() {
    VibrantGradientBackground()
}
