package com.example.adaptivelayoutcompose.data

import androidx.annotation.StringRes
import com.example.adaptivelayoutcompose.R

enum class Category(@StringRes val labelId: Int) {
    Pastry(R.string.pastry),
    Candy(R.string.candy),
    Chocolate(R.string.chocolate),
    Misc(R.string.misc),
}

class Sweets(
    val id: Int,
    val imageUrl: String,
    @StringRes val description: Int,
    val category: Category = Category.Misc
)