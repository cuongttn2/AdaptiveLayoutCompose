package com.example.adaptivelayoutcompose.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.adaptivelayoutcompose.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SweetTopAppBar(onBackPressed: () -> Unit) {
    TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            BackButton(onBackPressed = onBackPressed)
        })
}

@Composable
private fun BackButton(onBackPressed: () -> Unit) {
    IconButton(onClick = onBackPressed) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
            contentDescription = null
        )
    }
}