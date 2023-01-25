package com.algorithm_questions_visualizer.ui.screens.problem.screen.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.algorithm_questions_visualizer.core.ui.compose.AutoResizedText
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.ui.theme.AndroidStudioCodeBackground
import com.algorithm_questions_visualizer.ui.theme.Orange
import com.algorithm_questions_visualizer.ui.theme.Yellow

@Composable
fun ProblemSolution(solution: String) {
    Column(modifier = Modifier
        .width(32.dp)
        .fillMaxHeight()) {
        for (i in 0..200) {
            //TODO - add lines composable
        }
    }
    AutoResizedText(
        modifier = Modifier
            .fillMaxSize()
            .background(AndroidStudioCodeBackground)
            .padding(32.dp),
        text = buildAnnotatedString {
            val kotlinKeywords = mutableListOf("fun", "val", "var", "if", "return", "null", ",")
            val kotlinExtensions = mutableListOf("forEachIndexed")
            solution.split(" ", ".").forEach { string ->
                if (kotlinKeywords.contains(string)) {
                    withStyle(
                        style = SpanStyle(
                            color = Orange
                        )
                    ) {
                        append(string)
                        append(' ')
                    }
                    return@forEach
                } else if (kotlinExtensions.contains(string)) {
                    appendInlineContent(" ", ".")
                    withStyle(
                        style = SpanStyle(
                            color = Yellow
                        )
                    ) {
                        append(string)
                        append(" ")
                    }
                    return@forEach
                }
                append(string)
                append(' ')
            }
        },
        color = Color.White,
    )
}

@Preview(showBackground = true)
@Composable
fun ProblemSolutionPreview() {
    ProblemSolution(solution = leetcode1.solution.solutionCode)
}