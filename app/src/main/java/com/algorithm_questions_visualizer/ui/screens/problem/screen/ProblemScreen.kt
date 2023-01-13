@file:OptIn(ExperimentalMaterial3Api::class)

package com.algorithm_questions_visualizer.ui.screens.problem.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import com.algorithm_questions_visualizer.ui.theme.AqvTheme

@Composable
fun ProblemScreen(
    modifier: Modifier = Modifier,
    algorithmicProblem: AlgorithmicProblem
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProblemScreenTopBar(algorithmicProblem)
        }) { paddingValues ->
        ProblemDescription(
            modifier = Modifier.padding(paddingValues),
            algorithmicProblem = algorithmicProblem
        )
    }
}


@Preview
@Composable
fun ProblemScreenPreview() {
    AqvTheme {
        ProblemScreen(
            algorithmicProblem = leetcode1
        )
    }
}