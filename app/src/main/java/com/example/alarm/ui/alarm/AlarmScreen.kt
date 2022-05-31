package com.example.alarm.ui.alarm

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarm.ui.theme.Theme

@Composable
fun AlarmScreen(
) {
    Column {
        AlarmItem()
        AlarmItem()
        AlarmItem()
        AlarmItem()
    }
}


@Composable
fun AlarmItem(

) {
    var checked by remember { mutableStateOf(false) }
    var expandedState by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Theme.colors.primaryBackground)
            .padding(19.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .clickable {
                expandedState = !expandedState
            },
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            Modifier
                .background(color = Theme.colors.secondaryBackground)
                .border(border = BorderStroke(0.dp, color = Theme.colors.secondaryBackground))
                .padding(19.dp),
            verticalArrangement = Arrangement.Center,

        ) {
            if (expandedState) {
                Text(
                    text = "Work",
                    fontSize = 14.sp,
                    color = Theme.colors.activeTextColor
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "8:30 ",
                    fontSize = 36.sp,
                    color = Theme.colors.activeTextColor
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClickableText(
                    text = AnnotatedString("S  M  T  W  T  F  S"),
                    onClick = { offset ->
                        Log.d("letter", "AlarmItem: $offset character is clicked")
                    },
                    style = TextStyle(color = Theme.colors.inactiveTextColor)
                )
                Switch(checked = checked, onCheckedChange = { checked = !checked })
            }
            if (expandedState) {
                Column() {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "S",
                            color = Theme.colors.activeTextColor,
                            fontSize = 26.sp
                        )
                        Text(
                            text = "M",
                            color = Theme.colors.activeTextColor,
                            fontSize = 26.sp
                        )
                        Text(
                            text = "T",
                            color = Theme.colors.activeTextColor,
                            fontSize = 26.sp
                        )
                        Text(
                            text = "W",
                            color = Theme.colors.activeTextColor,
                            fontSize = 26.sp
                        )
                        Text(
                            text = "T",
                            color = Theme.colors.activeTextColor,
                            fontSize = 26.sp
                        )
                        Text(
                            text = "F",
                            color = Theme.colors.activeTextColor,
                            fontSize = 26.sp
                        )
                        Text(
                            text = "S",
                            color = Theme.colors.activeTextColor,
                            fontSize = 26.sp
                        )
                    }
                    Text(text = "Delete")
                }
            }
        }
    }
}

@Preview
@Composable
fun PrevAlarmItem() {
    AlarmItem()
}