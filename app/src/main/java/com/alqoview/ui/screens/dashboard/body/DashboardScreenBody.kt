package com.alqoview.ui.screens.dashboard.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alqoview.R
import com.alqoview.model.AlgorithmicProblem
import com.alqoview.ui.screens.dashboard.list_item.AlgorithmProblemListItem

@Composable
fun DashboardScreenBody(
    algorithmicProblems: List<AlgorithmicProblem>,
    onItemClicked: (problemId: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 32.dp),
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
        LazyColumn(modifier = Modifier.padding(top = 32.dp)) {
            items(algorithmicProblems) { algorithmicProblem ->
                AlgorithmProblemListItem(
                    problemId = algorithmicProblem.problemId,
                    questionNumber = algorithmicProblem.questionNumber,
                    questionTitle = algorithmicProblem.title,
                    source = algorithmicProblem.source,
                    difficulty = algorithmicProblem.difficulty
                ) { problemId ->
                    onItemClicked(problemId)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenBodyPreview() {
    DashboardScreenBody(emptyList()) {}
}