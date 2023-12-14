import androidx.compose.runtime.Composable
import navigation.RootComponent

actual fun getPlatformName(): String = "Android"

@Composable fun MainView(root: RootComponent) = App(root)
