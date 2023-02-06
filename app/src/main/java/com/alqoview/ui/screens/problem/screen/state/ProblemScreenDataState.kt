package com.alqoview.ui.screens.problem.screen.state

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alqoview.data.source.leetcode1
import com.alqoview.model.AlgorithmicProblem
import com.alqoview.ui.screens.problem.screen.body.ProblemDescription
import com.alqoview.ui.screens.problem.screen.body.ProblemExplanation
import com.alqoview.ui.screens.problem.screen.body.ProblemSolution
import com.alqoview.ui.screens.problem.screen.top_bar.ProblemScreenTabs
import com.alqoview.ui.screens.problem.screen.top_bar.ProblemScreenTopBar
import com.alqoview.ui.theme.AqvTheme
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
                        description = algorithmicProblem.problemDescription,
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