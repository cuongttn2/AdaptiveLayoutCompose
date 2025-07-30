package com.example.adaptivelayoutcompose.ui.listdetailcompose

sealed class FoldState {
    object HalfOpened : FoldState()
    object Flat : FoldState()
    object Unknown : FoldState()
}