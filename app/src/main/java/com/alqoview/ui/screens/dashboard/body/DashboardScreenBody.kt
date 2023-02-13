package com.alqoview.ui.screens.dashboard.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.alqoview.model.AlgorithmicProblem
import com.alqoview.ui.screens.dashboard.list_item.AlgorithmProblemListItem

@Composable
fun DashboardScreenBody(
    algorithmicProblems: List<AlgorithmicProblem>,
    onItemClicked: (problemId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        items(algorithmicProblems) { algorithmicProblem ->
            AlgorithmProblemListItem(
                problemId = algorithmicProblem.problemId,
                questionNumber = algorithmicProblem.questionNumber,
                questionTitle = algorithmicProblem.title,
                source = algorithmicProblem.source
            ) { problemId ->
               onItemClicked(problemId)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenBodyPreview() {
    DashboardScreenBody(emptyList()) {}
}