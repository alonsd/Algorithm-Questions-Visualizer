package com.algorithm_questions_visualizer.core.extensions

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.algorithm_questions_visualizer.ui.theme.AqvTheme

fun ComponentActivity.setAqvContent(content: @Composable () -> Unit){
    setContent {
        AqvTheme {
            content()
        }
    }
}