package com.afauzi.tixievent.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.decode.SvgDecoder

@Composable
fun svgConverter(): ImageLoader {
    return ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
}