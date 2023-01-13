package com.algorithm_questions_visualizer.ui.screens.problem.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.algorithm_questions_visualizer.core.ui.compose.pagerTabIndicatorOffset
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProblemScreenTopBar(algorithmicProblem: AlgorithmicProblem) {

    val tabRowItems = listOf(
        TabRowItem(
            title = TabRowItem.ProblemScreenTabs.DESCRIPTION.value,
            screen = {
                ProblemDescription(algorithmicProblem = algorithmicProblem)
            },
        ),
        TabRowItem(
            title = TabRowItem.ProblemScreenTabs.EXPLANATION.value,
            screen = { Text(text = "Tab 2") }
        ),
        TabRowItem(
            title = TabRowItem.ProblemScreenTabs.SOLUTION.value,
            screen = {
                Text(text = "Tab 3")
            },
        )
    )
    val pagerState = com.google.accompanist.pager.rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            modifier = Modifier.pagerTabIndicatorOffset(pagerState, emptyList()),
            selectedTabIndex = pagerState.currentPage,
        ) {

        }
    }


}

@Preview(showBackground = true)
@Composable
fun ProblemScreenTopBarPreview() {
    ProblemScreenTopBar(leetcode1)
}