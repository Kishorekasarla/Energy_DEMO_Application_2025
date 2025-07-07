package com.infmenergy.ui.screens.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.infmenergy.ui.screens.mainscreen.MainScreen
import com.infmenergy.ui.theme.InfmEnergyTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.bkvenergy.R


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This ensures the system bars are drawn over (not behind) your content
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Set status and navigation bar background color
        window.statusBarColor = ContextCompat.getColor(this, R.color.Theme_color)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.Theme_color)

        setContent {
            InfmEnergyTheme {
                MainScreen() // Ensure LoginScreen is actually visible on launch
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InfmEnergyTheme {
        Greeting("Android")
    }
}