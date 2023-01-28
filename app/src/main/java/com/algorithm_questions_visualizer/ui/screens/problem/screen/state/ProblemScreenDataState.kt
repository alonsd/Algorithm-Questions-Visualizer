package com.algorithm_questions_visualizer.ui.screens.problem.screen.state

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import com.algorithm_questions_visualizer.ui.screens.problem.screen.body.ProblemDescription
import com.algorithm_questions_visualizer.ui.screens.problem.screen.body.ProblemExplanation
import com.algorithm_questions_visualizer.ui.screens.problem.screen.body.ProblemSolution
import com.algorithm_questions_visualizer.ui.screens.problem.screen.top_bar.ProblemScreenTabs
import com.algorithm_questions_visualizer.ui.screens.problem.screen.top_bar.ProblemScreenTopBar
import com.algorithm_questions_visualizer.ui.theme.AqvTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun ProblemScreenDataState(
    modifier: Modifier = Modifier,
    algorithmicProblem: AlgorithmicProblem
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProblemScreenTopBar(
                algorithmicProblem.questionNumber.toString(),
                algorithmicProblem.title,
                pagerState.currentPage
            ) { index ->
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
                        description = algorithmicProblem.description,
                        examples = algorithmicProblem.examples
                    )
                }
                ProblemScreenTabs.EXPLANATION.ordinal -> {
                    ProblemExplanation(algorithmicProblem.solution.explanation)
                }
                ProblemScreenTabs.SOLUTION.ordinal -> {
                    ProblemSolution(algorithmicProblem.solution.solutionCode)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProblemScreenDataStatePreview() {
    AqvTheme {
        ProblemScreenDataState(algorithmicProblem = leetcode1)
    }
}