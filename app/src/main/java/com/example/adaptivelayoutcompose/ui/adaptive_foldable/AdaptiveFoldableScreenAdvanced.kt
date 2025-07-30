package com.example.adaptivelayoutcompose.ui.adaptive_foldable

import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.adaptivelayoutcompose.ui.extensions.findActivity

@Composable
fun AdaptiveFoldableScreenAdvanced(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activity = context.findActivity()
    val foldInfo by rememberFoldInfo(activity)

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    when {
        // HALF_OPENED với bản lề dọc → chia trái - phải
        foldInfo.state is FoldState.HalfOpened &&
                foldInfo.orientation == FoldOrientation.VERTICAL -> {
            val hingeDp = foldInfo.hingeBounds?.width()?.dp ?: 0.dp
            DualPaneLayoutWithHinge(
                leftWeight = (screenWidth - hingeDp) / 2,
                rightWeight = (screenWidth - hingeDp) / 2,
                hingeWidth = hingeDp
            )
            Log.d("TAG", "AdaptiveFoldableScreenAdvanced\n: $foldInfo")
        }

        // HALF_OPENED với bản lề ngang → chia trên - dưới
        foldInfo.state is FoldState.HalfOpened &&
                foldInfo.orientation == FoldOrientation.HORIZONTAL -> {
            val hingeDp = foldInfo.hingeBounds?.height()?.dp ?: 0.dp
            DualPaneVerticalWithHinge(
                topWeight = (screenHeight - hingeDp) / 2,
                bottomWeight = (screenHeight - hingeDp) / 2,
                hingeHeight = hingeDp
            )
            Log.d("TAG", "AdaptiveFoldableScreenAdvanced\n: $foldInfo")
        }

        // FLAT nhưng màn hình rộng → dual-pane tối ưu
        foldInfo.state is FoldState.Flat &&
                screenWidth >= 600.dp -> {
            DualPaneLayout2(modifier)
            Log.d("TAG", "AdaptiveFoldableScreenAdvanced\n: $foldInfo")
        }

        // Còn lại → single pane
        else -> {
            SinglePaneLayout2(modifier)
            Log.d("TAG", "AdaptiveFoldableScreenAdvanced\n: $foldInfo")
        }
    }
}

@Composable
fun DualPaneLayoutWithHinge(leftWeight: Dp, rightWeight: Dp, hingeWidth: Dp) {
    Row(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Box(
            Modifier
                .width(leftWeight)
                .fillMaxHeight()
        ) { PaneContent(label = "📖 Left Pane") }

        Spacer(Modifier.width(hingeWidth))

        Box(
            Modifier
                .width(rightWeight)
                .fillMaxHeight()
        ) { PaneContent(label = "📖 Right Pane") }
    }
}

@Composable
fun DualPaneVerticalWithHinge(topWeight: Dp, bottomWeight: Dp, hingeHeight: Dp) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Box(
            Modifier
                .height(topWeight)
                .fillMaxWidth()
        ) { PaneContent(label = "📖 Top Pane") }

        Spacer(Modifier.height(hingeHeight))

        Box(
            Modifier
                .height(bottomWeight)
                .fillMaxWidth()
        ) { PaneContent(label = "📖 Bottom Pane") }
    }
}

@Composable
fun DualPaneLayout2(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Box(
            Modifier
                .weight(1f)
                .fillMaxHeight()
        ) { PaneContent(label = "📖 Left Pane") }

        Box(
            Modifier
                .weight(1f)
                .fillMaxHeight()
        ) { PaneContent(label = "📖 Right Pane") }
    }
}

@Composable
fun SinglePaneLayout2(modifier: Modifier = Modifier) {
    PaneContent(modifier = modifier, label = "📱 Single Pane")
}

@Composable
fun PaneContent(modifier: Modifier = Modifier, label: String) {
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        items(10) { i ->
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text("$label - Item ${i + 1}", Modifier.padding(16.dp))
            }
        }
    }
}