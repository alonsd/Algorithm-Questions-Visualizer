package com.alqoview.ui.screens.problem.screen.body.explanation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alqoview.data.source.leetcode1
import com.alqoview.model.AlgorithmicProblem.Solution.Explanation.CoreConcept

@Composable
fun ExplanationCoreConceptItem(
    coreConcept: CoreConcept
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(
                vertical = 16.dp,
                horizontal = 8.dp
            )
    ) {
        Text(
            text = coreConcept.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            modifier = Modifier.padding(
                vertical = 8.dp,
            ),
            text = coreConcept.description,
            fontSize = 12.sp,
            fontWeight = FontWeight.Thin
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExplanationCoreConceptItemPreview() {
    ExplanationCoreConceptItem(leetcode1.solution.explanation.coreConcepts[0])
}