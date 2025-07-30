package com.example.adaptivelayoutcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.adaptivelayoutcompose.ui.listdetailcompose.FoldStateDemoScreen
import com.example.adaptivelayoutcompose.ui.theme.AdaptiveLayoutComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdaptiveLayoutComposeTheme {
                Scaffold { innerPadding ->
//                    ListDetailSample(modifier = Modifier.fillMaxSize().padding(innerPadding))
                    FoldStateDemoScreen(modifier = Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
    }
}
