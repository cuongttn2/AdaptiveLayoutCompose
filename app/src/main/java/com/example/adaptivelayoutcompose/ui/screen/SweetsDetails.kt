package com.example.adaptivelayoutcompose.ui.screen
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.adaptivelayoutcompose.R
import com.example.adaptivelayoutcompose.data.Sweets
import com.example.adaptivelayoutcompose.ui.components.SweetTopAppBar

@Composable
fun SweetsDetails(
    sweets: Sweets,
    windowSizeClass: WindowSizeClass,
    onBackPressed: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Expanded -> SweetsDetailsHorizontal(
            sweets = sweets,
            scrollState = scrollState,
            onBackPressed = onBackPressed
        )

        WindowWidthSizeClass.Compact -> SweetsDetailsVertical(
            sweets = sweets,
            scrollState = scrollState,
            onBackPressed = onBackPressed
        )

        else -> {
            when (windowSizeClass.heightSizeClass) {
                WindowHeightSizeClass.Expanded -> SweetsDetailsVertical(
                    sweets = sweets,
                    scrollState = scrollState,
                    onBackPressed = onBackPressed
                )

                else -> SweetsDetailsHorizontal(
                    sweets = sweets,
                    scrollState = scrollState,
                    onBackPressed = onBackPressed
                )
            }
        }
    }
}

@Composable
private fun SweetsDetailsVertical(
    sweets: Sweets,
    scrollState: ScrollState,
    onBackPressed: () -> Unit
) {
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        SweetTopAppBar(onBackPressed = onBackPressed)
        AsyncImage(
            model = sweets.imageUrl,
            contentDescription = stringResource(id = R.string.thumbnail_content_description),
            modifier = Modifier
                .aspectRatio(1.414f)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = sweets.description),
            modifier = Modifier.padding(32.dp)
        )
    }
}

@Composable
private fun SweetsDetailsHorizontal(
    sweets: Sweets,
    scrollState: ScrollState,
    onBackPressed: () -> Unit
) {
    Column {
        SweetTopAppBar(onBackPressed = onBackPressed)
        Row {
            AsyncImage(
                model = sweets.imageUrl,
                contentDescription = stringResource(id = R.string.thumbnail_content_description),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder_sweets),
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1.0f)
            )
            Text(
                text = stringResource(id = sweets.description),
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp, bottom = 32.dp)
                    .weight(1.0f)
                    .verticalScroll(scrollState)
            )
        }
    }
}