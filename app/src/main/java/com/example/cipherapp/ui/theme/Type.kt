package com.example.cipherapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val QuickSand = FontFamily(
    Font(com.example.cipherapp.R.font.quicksand_regular, FontWeight.W400),
    Font(com.example.cipherapp.R.font.quicksand_semibold, FontWeight.W600)
)

private val Braille = FontFamily(
    Font(com.example.cipherapp.R.font.braille)
)

val QuickSandTypography = Typography(
    defaultFontFamily = QuickSand,
    h2 = TextStyle(
        fontSize = 64.sp,
        fontWeight = FontWeight.W600
    ),
    button = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 64.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 24.sp
    )
)

val BrailleTypography = Typography(
    h2 = TextStyle(
        fontFamily = Braille,
        fontSize = 64.sp
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)