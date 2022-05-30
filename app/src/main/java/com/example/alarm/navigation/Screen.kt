package com.example.alarm.navigation

import androidx.annotation.StringRes
import com.example.alarm.R

sealed class Screen(val route: String, @StringRes val stringId: Int, val iconId: Int) {
    object Alarm : Screen(NavigationTree.Alarm.name, R.string.alarm, R.drawable.alarm)
    object Clock : Screen(NavigationTree.Clock.name, R.string.clock, R.drawable.clock)
    object Timer : Screen(NavigationTree.Timer.name, R.string.timer, R.drawable.timer)
    object Stopwatch : Screen(NavigationTree.Stopwatch.name, R.string.stopwatch, R.drawable.stopwatch)
}
