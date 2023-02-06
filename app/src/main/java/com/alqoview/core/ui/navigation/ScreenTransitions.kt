package com.alqoview.core.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(ExperimentalAnimationApi::class)
object ScreenTransitions : DestinationStyle.Animated {

    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {
        return slideInHorizontally(
            initialOffsetX = { 1000 },
            animationSpec = tween(700)
        )
    }


    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {
        return slideOutHorizontally(
            targetOffsetX = { -1000 },
            animationSpec = tween(700)
        )
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition? {
        return slideInHorizontally(
            initialOffsetX = { -1000 },
            animationSpec = tween(700)
        )
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popExitTransition(): ExitTransition? {
        return slideOutHorizontally(
            targetOffsetX = { 1000 },
            animationSpec = tween(700)
        )
    }
}