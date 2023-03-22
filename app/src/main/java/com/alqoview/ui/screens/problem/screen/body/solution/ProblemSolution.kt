package com.alqoview.ui.screens.problem.screen.body.solution

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alqoview.core.ui.compose.AutoResizedText
import com.alqoview.data.source.leetcode1
import com.alqoview.ui.theme.AndroidStudioCodeBackground
import com.alqoview.ui.theme.Orange
import com.alqoview.ui.theme.Purple200
import com.alqoview.ui.theme.Yellow

@Composable
fun ProblemSolution(solution: String) {

    var solutionLineFontSize by remember { mutableStateOf(16f) }

    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .width(32.dp)
                .fillMaxHeight()
        ) {
            LazyColumn {
                val linesCount = solution
                    .count { "\n".contains(it) }
                    .coerceAtLeast(50)
                items(linesCount) { line ->
                    SolutionLineCode(lineOfCode = line, solutionLineFontSize)
                }
            }
        }
        val keywords = setOf("class", "fun", "val", "var", "if", "else", "when", "is", "in", "return", "while")
        val extensions = setOf("forEachIndexed")

        val keywordsColor = Orange
        val extensionsColor = Yellow
        val variablesColor = Purple200
        val lines = solution.split("\n")

        AutoResizedText(
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight()
                .background(AndroidStudioCodeBackground)
                .padding(0.dp),
            text = buildAnnotatedString {
                lines.forEach { line ->
                    val words = line.split(" ")
                    words.forEachIndexed { index, word ->
                        if (line.startsWith("//")) {
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append(line)
                            }
                            return@forEachIndexed
                        }
                        val color = when {
                            word in keywords -> keywordsColor
                            word in extensions -> extensionsColor
                            index > 0 && words[index - 1] == "." -> variablesColor
                            else -> Color.White
                        }
                        withStyle(style = SpanStyle(color = color)) {
                            append("$word ")
                        }
                    }
                    append("\n")
                }
            },
            onTextSizeFinalized = { size ->
                solutionLineFontSize = size
            })
    }
}

@Preview(showBackground = true)
@Composable
fun ProblemSolutionPreview() {
    ProblemSolution(solution = leetcode1.solution.solutionCode)
}