package com.algorithm_questions_visualizer.ui.screens.problem.screen.body

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.ui.theme.Orange
import com.algorithm_questions_visualizer.ui.theme.Yellow

fun twoSum(numbers: IntArray, target: Int): IntArray? {
    val map = hashMapOf<Int, Int>()
    numbers.forEachIndexed { index, value ->
        val complement = target - value
        if (map.containsKey(complement))
            return intArrayOf(map[complement]!!, index)
        map[value] = index
    }
    return null
}

@Composable
fun ProblemSolution(solution: String) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        text = buildAnnotatedString {
            val kotlinKeywords = mutableListOf("fun", "val", "var", "if", "return", "null", ",")
            val kotlinExtensions = mutableListOf("forEachIndexed")
            solution.split(' ').forEach { string ->
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
                    withStyle(
                        style = SpanStyle(
                            color = Yellow
                        )
                    ) {
                        append(string)
                        append(' ')
                    }
                    return@forEach
                }
                append(string)
                append(' ')
            }
        },
        color = Color.White,
        fontSize = 16.sp
    )
}

@Preview(showBackground = true)
@Composable
fun ProblemSolutionPreview() {
    ProblemSolution(solution = leetcode1.solution)
}