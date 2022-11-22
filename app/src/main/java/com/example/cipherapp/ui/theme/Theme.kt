package com.example.cipherapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.cipherapp.R

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CipherAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = QuickSandTypography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun CipherAppThemeWithBackground(content: @Composable () -> Unit) {
    val bg = painterResource(id = R.drawable.interlaced)
    Box {
        Image(painter = bg, contentDescription = "bg", modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), contentScale = ContentScale.Crop)
        CipherAppTheme(content = content)
    }
}


@Composable
fun BrailleTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = BrailleTypography,
        content = content
    )
}