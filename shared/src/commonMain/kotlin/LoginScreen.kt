import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Header(modifier: Modifier) {
    Icon(
        imageVector = Icons.Default.Close, contentDescription = "Close App", modifier = modifier
    )
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(modifier = modifier.verticalScroll(scrollState).imePadding()) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        Email(email) { email = it }
        Spacer(modifier = Modifier.size(4.dp))
        PasswordField(password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPasswordText(Modifier.align(Alignment.End))
        BtnLogin(Modifier.align(Alignment.CenterHorizontally))
        BtnLoginWithGmail(Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun ForgotPasswordText(modifier: Modifier) {
    Text(
        text = "Forgot password",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource("logo.png"),
        contentDescription = "Logo",
        modifier = modifier
            .size(width = 150.dp, height = 150.dp)
    )
}

@Composable
fun Email(email: String, onTextChange: (String) -> Unit) {
    TextField(value = email, onValueChange = { onTextChange(it) })
}


@Composable
fun PasswordField(password: String, onTextChange: (String) -> Unit) {
    TextField(value = password, onValueChange = { onTextChange(it) })
}

@Composable
fun BtnLogin(modifier: Modifier) {
    Button(
        modifier = modifier
            .width(200.dp),
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta, contentColor = Color.Blue
        )
    ) {
        Text(text = "Login")
    }
}

@Composable
fun BtnLoginWithGmail(modifier: Modifier) {
    Button(
        onClick = { /* TODO: Acción de login con Gmail */ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White, contentColor = Color.Black
        ),
        modifier = modifier.width(200.dp) // Ancho personalizado para el botón
    ) {
        Icon(
            imageVector = Icons.Default.Email, // Icono que simboliza Gmail
            contentDescription = "Login with Gmail",
            modifier = Modifier.size(24.dp) // Tamaño del icono
        )
        Spacer(Modifier.size(8.dp)) // Espacio entre icono y texto
        Text(text = "Login with Gmail")
    }
}


