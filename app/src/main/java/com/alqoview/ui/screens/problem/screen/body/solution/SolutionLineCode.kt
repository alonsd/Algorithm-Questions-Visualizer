package com.alqoview.ui.screens.problem.screen.body.solution

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alqoview.ui.theme.AndroidStudioCodeLinesBackgroundColor
import com.alqoview.ui.theme.AndroidStudioCodeLinesColor

@Composable
fun SolutionLineCode(lineOfCode: Int, fontSize : Float) {
    Row(
        modifier = Modifier
            .background(AndroidStudioCodeLinesBackgroundColor)
            .width(67.dp)
            .wrapContentHeight()
            .padding(start = 0.dp, end = 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = if (lineOfCode < 10) " $lineOfCode" else lineOfCode.toString(),
            fontSize = fontSize.sp,
            color = AndroidStudioCodeLinesColor,
        )
        Spacer(modifier = Modifier.weight(1f))
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
            thickness = 1.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SolutionLineCodePreview() {
    SolutionLineCode(999, 41f)
}