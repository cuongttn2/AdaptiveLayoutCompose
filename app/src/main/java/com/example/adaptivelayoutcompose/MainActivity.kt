package com.example.adaptivelayoutcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.ui.Modifier
import com.example.adaptivelayoutcompose.ui.supporting_pane.SupportingPaneSample
import com.example.adaptivelayoutcompose.ui.theme.AdaptiveLayoutComposeTheme

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdaptiveLayoutComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SupportingPaneSample(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
