import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.ScreenLoginComponent
import navigation.ScreenLoginEvent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginScreen(component: ScreenLoginComponent) {

    val text by component.text.subscribeAsState()

    Box(Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource("fondo.png"),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp)
        ) {
            GmailLoginButton {
                component.onEvent(ScreenLoginEvent.ClickButtonLogin)
            }
        }
    }
}

@Composable
fun GmailLoginButton(onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(width = 300.dp, height = 50.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Iniciar sesión con Gmail",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF34A853)
        )
        // Puedes agregar aquí un icono de Gmail si lo deseas
    }
}