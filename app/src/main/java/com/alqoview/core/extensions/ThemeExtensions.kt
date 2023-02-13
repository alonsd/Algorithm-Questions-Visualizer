package com.alqoview.core.extensions

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.alqoview.ui.theme.AqvTheme

fun ComponentActivity.setAqvContent(content: @Composable () -> Unit){
    setContent {
        AqvTheme {
            content()
        }
    }
}