package com.algorithm_questions_visualizer.ui.screens.problem.screen.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.algorithm_questions_visualizer.ui.theme.AndroidStudioCodeLinesBackgroundColor

@Composable
fun SolutionLineCode(lineOfCode: Int) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)
            .background(AndroidStudioCodeLinesBackgroundColor)
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun SolutionLineCodePreview() {
    SolutionLineCode(1)
}