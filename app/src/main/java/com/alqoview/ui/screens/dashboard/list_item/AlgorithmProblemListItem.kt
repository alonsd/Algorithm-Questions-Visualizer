package com.alqoview.ui.screens.dashboard.list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alqoview.model.AlgorithmicProblem
import com.alqoview.ui.theme.*

@Composable
fun AlgorithmProblemListItem(
    problemId: Int,
    questionNumber: Int,
    questionTitle: String,
    source: AlgorithmicProblem.Source,
    difficulty: AlgorithmicProblem.Difficulty,
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
        val difficultyTextColors = when (difficulty) {
            AlgorithmicProblem.Difficulty.EASY -> GreenEasyBackground to GreenEasyColor
            AlgorithmicProblem.Difficulty.MEDIUM -> OrangeMediumBackground to OrangeMediumColor
            AlgorithmicProblem.Difficulty.HARD -> RedHardBackground to RedHardColor
        }
        Image(
            modifier = Modifier.size(20.dp, 20.dp),
            painter = painterResource(
                id = when (source) {
                    AlgorithmicProblem.Source.LEETCODE -> com.alqoview.R.drawable.leetcode_logo
                    AlgorithmicProblem.Source.HACKER_RANK -> com.alqoview.R.drawable.leetcode_logo
                }
            ),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.width(150.dp),
            text = stringResource(
                id = com.alqoview.R.string.question_title,
                questionNumber, questionTitle
            ),
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .background(difficultyTextColors.first, CircleShape)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .align(Alignment.CenterVertically)
                .size(50.dp, 16.dp),
            text = difficulty.name,
            textAlign = TextAlign.Center,
            color = difficultyTextColors.second,
            fontSize = 12.sp
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
        AlgorithmicProblem.Source.LEETCODE,
        AlgorithmicProblem.Difficulty.HARD,
    ) {}
}