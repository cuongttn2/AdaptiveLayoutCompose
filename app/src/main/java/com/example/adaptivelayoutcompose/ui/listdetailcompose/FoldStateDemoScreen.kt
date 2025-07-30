package com.example.adaptivelayoutcompose.ui.listdetailcompose

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import kotlinx.coroutines.flow.map

@Composable
fun FoldStateDemoScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activity = context.findActivity()

    val foldState by rememberFoldState(activity)

    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(
            color = Color.Black,
            fontSize = 24.sp,
            text = when (foldState) {
                is FoldState.HalfOpened -> "📖 Device is Half-Opened"
                is FoldState.Flat -> "📱 Device is Fully Flat / Open"
                is FoldState.Unknown -> "❓ Unknown Fold State"
            }
        )
    }
}

@Composable
fun rememberFoldState(activity: Activity): MutableState<FoldState> {
    val state = remember { mutableStateOf<FoldState>(FoldState.Unknown) }

    LaunchedEffect(Unit) {
        WindowInfoTracker.getOrCreate(activity).windowLayoutInfo(activity).map { layoutInfo ->
            layoutInfo.displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()
        }.collect { foldingFeature ->
            state.value = when {
                foldingFeature == null -> FoldState.Unknown
                foldingFeature.state == FoldingFeature.State.HALF_OPENED -> FoldState.HalfOpened

                foldingFeature.state == FoldingFeature.State.FLAT -> FoldState.Flat

                else -> FoldState.Unknown
            }
        }
    }
    return state
}

fun Context.findActivity(): Activity {
    var ctx = this
    while (ctx is android.content.ContextWrapper) {
        if (ctx is Activity) return ctx
        ctx = ctx.baseContext
    }
    throw IllegalStateException("Activity not found")
}