package com.alqoview.ui.screens.problem.screen.body

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alqoview.data.source.leetcode1
import com.alqoview.model.AlgorithmicProblem

@Composable
fun ProblemExplanation(explanation: AlgorithmicProblem.Solution.Explanation) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = explanation.explanationDescription,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProblemExplanationPreview() {
    ProblemExplanation(leetcode1.solution.explanation)
}