import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun rootNavGraphDefaultAnimations() = RootNavGraphDefaultAnimations(
    enterTransition = {
        slideInHorizontally(
            initialOffsetX = { 1000 },
            animationSpec = tween(700)
        )
    },
    exitTransition = {
        slideOutHorizontally(
            targetOffsetX = { -1000 },
            animationSpec = tween(700)
        )
    },
    popEnterTransition = {
        slideInHorizontally(
            initialOffsetX = { -1000 },
            animationSpec = tween(700)
        )
    },
    popExitTransition = {
        slideOutHorizontally(
            targetOffsetX = { 1450 }, // TODO - adjust according to screen size
            animationSpec = tween(700)
        )
    })