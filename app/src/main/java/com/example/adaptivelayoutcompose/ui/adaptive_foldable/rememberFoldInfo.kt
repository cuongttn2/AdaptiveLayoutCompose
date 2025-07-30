package com.example.adaptivelayoutcompose.ui.adaptive_foldable

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.window.layout.WindowInfoTracker
import com.example.adaptivelayoutcompose.ui.extensions.parseFoldInfo

@Composable
fun rememberFoldInfo(activity: Activity): MutableState<FoldInfo> {
    val state =
        remember { mutableStateOf(FoldInfo(FoldState.Unknown, FoldOrientation.UNKNOWN, null)) }

    LaunchedEffect(Unit) {
        WindowInfoTracker.getOrCreate(activity)
            .windowLayoutInfo(activity)
            .collect { layoutInfo ->
                state.value = parseFoldInfo(layoutInfo)
            }
    }
    return state
}