package com.algorithm_questions_visualizer.ui.screens.dashboard.state.data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.algorithm_questions_visualizer.R
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import com.algorithm_questions_visualizer.ui.theme.AqvTheme

@Composable
fun ProblemScreen(
    modifier: Modifier = Modifier,
    algorithmicProblem: AlgorithmicProblem
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
            Text(
                text = stringResource(
                    id = R.string.problem_screen_question_title,
                    algorithmicProblem.questionNumber,
                    algorithmicProblem.title
                ),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = algorithmicProblem.description,
                modifier = Modifier.padding(top = 16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
//            LazyColumn {
//                itemsIndexed(algorithmicProblem.examples) { index, item ->
//
//                }
//            }
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