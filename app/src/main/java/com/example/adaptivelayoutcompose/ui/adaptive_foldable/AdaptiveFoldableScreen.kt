package com.example.adaptivelayoutcompose.ui.adaptive_foldable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.adaptivelayoutcompose.ui.extensions.findActivity

@Composable
fun AdaptiveFoldableScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activity = context.findActivity()
    val foldState by rememberFoldState(activity)

    when (foldState) {
        is FoldState.HalfOpened -> DualPaneLayout(modifier = modifier)
        is FoldState.Flat -> DualPaneLayout(modifier = modifier)
        is FoldState.Unknown -> SinglePaneLayout(modifier = modifier)
    }
}

