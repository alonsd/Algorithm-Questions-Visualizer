package com.algorithm_questions_visualizer.ui.screens.problem.screen.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.algorithm_questions_visualizer.ui.theme.AndroidStudioCodeLinesBackgroundColor
import com.algorithm_questions_visualizer.ui.theme.AndroidStudioCodeLinesColor

@Composable
fun SolutionLineCode(lineOfCode: Int) {
    Row(
        modifier = Modifier
            .background(AndroidStudioCodeLinesBackgroundColor)
            .width(67.dp)
            .padding(start = 0.dp, end = 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = lineOfCode.toString(),
            fontSize = 16.sp,
            color = AndroidStudioCodeLinesColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SolutionLineCodePreview() {
    SolutionLineCode(999)
}