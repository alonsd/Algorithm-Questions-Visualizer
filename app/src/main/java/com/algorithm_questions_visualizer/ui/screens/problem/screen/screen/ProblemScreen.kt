@file:OptIn(ExperimentalMaterial3Api::class)

package com.algorithm_questions_visualizer.ui.screens.problem.screen.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import com.algorithm_questions_visualizer.ui.screens.problem.screen.body.ProblemDescription
import com.algorithm_questions_visualizer.ui.screens.problem.screen.top_bar.ProblemScreenTopBar
import com.algorithm_questions_visualizer.ui.screens.problem.screen.top_bar.ProblemScreenTabs
import com.algorithm_questions_visualizer.ui.theme.AqvTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProblemScreen(
    modifier: Modifier = Modifier,
    algorithmicProblem: AlgorithmicProblem
) {

    val pagerState = rememberPagerState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProblemScreenTopBar(pagerState)
        }) { paddingValues ->
        HorizontalPager(
            count = ProblemScreenTabs.values().size,
            state = pagerState
        ) { page ->
            Log.d("defaultAppDebuger", "curentPager: $page")
            when (page) {
                ProblemScreenTabs.DESCRIPTION.ordinal -> {
                    ProblemDescription(
                        modifier = Modifier.padding(paddingValues),
                        algorithmicProblem = algorithmicProblem
                    )
                }
                ProblemScreenTabs.EXPLANATION.ordinal -> {
                    Log.d("defaultAppDebuger", "EXPLANATION")
                }
                ProblemScreenTabs.SOLUTION.ordinal -> {
                    Log.d("defaultAppDebuger", "SOLUTION")
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