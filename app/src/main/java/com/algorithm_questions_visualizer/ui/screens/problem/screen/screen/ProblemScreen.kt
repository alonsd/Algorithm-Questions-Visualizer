@file:OptIn(ExperimentalMaterial3Api::class)

package com.algorithm_questions_visualizer.ui.screens.problem.screen.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import com.algorithm_questions_visualizer.ui.screens.problem.screen.body.ProblemDescription
import com.algorithm_questions_visualizer.ui.screens.problem.screen.body.ProblemSolution
import com.algorithm_questions_visualizer.ui.screens.problem.screen.top_bar.ProblemScreenTabs
import com.algorithm_questions_visualizer.ui.screens.problem.screen.top_bar.ProblemScreenTopBar
import com.algorithm_questions_visualizer.ui.theme.AqvTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProblemScreen(
    modifier: Modifier = Modifier,
    algorithmicProblem: AlgorithmicProblem
) {

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProblemScreenTopBar(pagerState.currentPage) { index ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }
        }) { paddingValues ->
        HorizontalPager(
            modifier = Modifier.padding(paddingValues),
            count = ProblemScreenTabs.values().size,
            state = pagerState
        ) { page ->
            when (page) {
                ProblemScreenTabs.DESCRIPTION.ordinal -> {
                    ProblemDescription(
                        algorithmicProblem = algorithmicProblem
                    )
                }
                ProblemScreenTabs.EXPLANATION.ordinal -> {
                    Text(
                        modifier = Modifier.fillMaxSize(),
                        text = "Explanation",
                        color = Color.White,
                        fontSize = 36.sp
                    )
                }
                ProblemScreenTabs.SOLUTION.ordinal -> {
                    ProblemSolution(algorithmicProblem.solution)
                }
            }
        }
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