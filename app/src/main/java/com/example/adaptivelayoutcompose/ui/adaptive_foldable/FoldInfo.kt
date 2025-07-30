package com.example.adaptivelayoutcompose.ui.adaptive_foldable

import android.graphics.Rect

data class FoldInfo(
    val state: FoldState,
    val orientation: FoldOrientation,
    val hingeBounds: Rect? = null
)