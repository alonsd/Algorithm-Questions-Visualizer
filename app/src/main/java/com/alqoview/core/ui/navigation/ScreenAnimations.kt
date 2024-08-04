import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations

fun rootNavGraphDefaultAnimations(screenWidth: Int) = RootNavGraphDefaultAnimations(
    enterTransition = {
        slideInHorizontally(
            initialOffsetX = { screenWidth },
            animationSpec = tween(700)
        )
    },
    exitTransition = {
        slideOutHorizontally(
            targetOffsetX = { -screenWidth },
            animationSpec = tween(700)
        )
    },
    popEnterTransition = {
        slideInHorizontally(
            initialOffsetX = { -screenWidth },
            animationSpec = tween(700)
        )
    },
    popExitTransition = {
        slideOutHorizontally(
            targetOffsetX = { screenWidth },
            animationSpec = tween(700)
        )
    }
)