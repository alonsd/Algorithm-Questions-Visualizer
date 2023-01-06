package com.algorithm_questions_visualizer.core.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope

@Composable
fun SingleTimeLaunchedEffect(block: suspend CoroutineScope.() -> Unit) = LaunchedEffect(key1 = true, block = block)