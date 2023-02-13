package com.alqoview.ui.screens.dashboard.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alqoview.model.AlgorithmicProblem

@Composable
fun AlgorithmProblemListItem(
    problemId: Int,
    questionNumber: Int,
    questionTitle: String,
    source: AlgorithmicProblem.Source,
    onItemClicked: (problemId: Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Black)
            .padding(vertical = 16.dp, horizontal = 32.dp)
            .clickable {
                onItemClicked(problemId)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(
                id = com.alqoview.R.string.question_title,
                questionNumber, questionTitle
            ),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            modifier = Modifier.size(30.dp, 30.dp),
            painter = painterResource(
                id = when (source) {
                    AlgorithmicProblem.Source.LEETCODE -> com.alqoview.R.drawable.leetcode_logo
                    AlgorithmicProblem.Source.HACKER_RANK -> com.alqoview.R.drawable.leetcode_logo
                }
            ),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlgorithmProblemListItemPreview() {
    AlgorithmProblemListItem(
        1,
        1,
        "Two Sum",
        AlgorithmicProblem.Source.LEETCODE
    ) {}
}