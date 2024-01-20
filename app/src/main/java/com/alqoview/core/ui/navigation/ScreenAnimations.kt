import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.animations.defaults.DestinationEnterTransition
import com.ramcosta.composedestinations.animations.defaults.DestinationExitTransition
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations

@OptIn(ExperimentalAnimationApi::class)
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