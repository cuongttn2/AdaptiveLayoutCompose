package com.example.adaptivelayoutcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.adaptivelayoutcompose.ui.listdetailcompose.ListDetailSample
import com.example.adaptivelayoutcompose.ui.theme.AdaptiveLayoutComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdaptiveLayoutComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ListDetailSample()
                }
            }
        }
    }
}
