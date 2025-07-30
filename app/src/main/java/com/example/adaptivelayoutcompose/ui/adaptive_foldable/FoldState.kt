package com.example.adaptivelayoutcompose.ui.adaptive_foldable

sealed class FoldState {
    object HalfOpened : FoldState()
    object Flat : FoldState()
    object Unknown : FoldState()
}