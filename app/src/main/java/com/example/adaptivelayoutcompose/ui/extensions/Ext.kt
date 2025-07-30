package com.example.adaptivelayoutcompose.ui.extensions

import android.app.Activity
import android.content.Context
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowLayoutInfo
import com.example.adaptivelayoutcompose.ui.adaptive_foldable.FoldInfo
import com.example.adaptivelayoutcompose.ui.adaptive_foldable.FoldOrientation
import com.example.adaptivelayoutcompose.ui.adaptive_foldable.FoldState

fun Context.findActivity(): Activity {
    var ctx = this
    while (ctx is android.content.ContextWrapper) {
        if (ctx is Activity) return ctx
        ctx = ctx.baseContext
    }
    throw IllegalStateException("Activity not found")
}

fun parseFoldInfo(layoutInfo: WindowLayoutInfo): FoldInfo {
    val foldingFeature = layoutInfo.displayFeatures
        .filterIsInstance<FoldingFeature>()
        .firstOrNull()

    return if (foldingFeature != null) {
        val orientation = when (foldingFeature.orientation) {
            FoldingFeature.Orientation.HORIZONTAL -> FoldOrientation.HORIZONTAL
            FoldingFeature.Orientation.VERTICAL -> FoldOrientation.VERTICAL
            else -> FoldOrientation.UNKNOWN
        }
        val state = when (foldingFeature.state) {
            FoldingFeature.State.HALF_OPENED -> FoldState.HalfOpened
            FoldingFeature.State.FLAT -> FoldState.Flat
            else -> FoldState.Unknown
        }
        FoldInfo(state, orientation, foldingFeature.bounds)
    } else {
        FoldInfo(FoldState.Unknown, FoldOrientation.UNKNOWN, null)
    }
}