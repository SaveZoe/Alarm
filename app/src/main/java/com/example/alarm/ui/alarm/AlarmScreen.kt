package com.example.alarm.ui.alarm

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AlarmScreen(
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        item {
            AlarmItem()
        }
        item {
            AlarmItem()
        }
        item {
            AlarmItem()
        }
        item {
            AlarmItem()
        }
        item {
            AlarmItem()
        }
    }
}


@Composable
fun AlarmItem(

) {
    Card(
        modifier = Modifier
            .width(169.dp)
            .height(177.dp)
            .background(color = Color.Red)
            .padding(19.dp)
    ) {
        Column(
            Modifier
                .background(Color.Red)
        ) {
            Text(
                text = "Work",
                fontSize = 14.sp,
                color = Color.White
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "8:30 ",
                    fontSize = 36.sp,
                    color = Color.White
                )
                Text(text = "AM", fontSize = 18.sp, color = Color.White)
            }

            ClickableText(
                text = AnnotatedString("S  M  T  W  T  F  S"),
                onClick = { offset ->
                    Log.d("letter", "AlarmItem: $offset character is clicked")
                },
                style = TextStyle(color = Color.White)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Switch(checked = false, onCheckedChange = { })
            }
        }
    }
}

@Preview
@Composable
fun PrevAlarmItem() {
    AlarmItem()
}