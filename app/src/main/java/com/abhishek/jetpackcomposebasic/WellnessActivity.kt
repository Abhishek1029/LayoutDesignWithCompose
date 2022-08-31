package com.abhishek.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abhishek.jetpackcomposebasic.ui.composables.StatefulCounter
import com.abhishek.jetpackcomposebasic.ui.composables.WellnessScreen
import com.abhishek.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class DrinkingWaterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicTheme {
                WellnessScreen()
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeBasicTheme {
        Greeting2("Android")
    }
}