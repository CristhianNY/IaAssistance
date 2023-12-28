package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import domain.example.model.PicturesEntityItemModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import navigation.ScreenHomeComponent
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    component: ScreenHomeComponent,
    homeViewModel: HomeViewModel = koinInject<HomeViewModel>()
) {

    val uiState by homeViewModel.uiState.collectAsState()

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Home Screen")
        Button(onClick = {
            homeViewModel.getData()
        }) {
            Text("Get Example Data")
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
            content = {
                items(uiState.images) {
                    ImageCell(it)
                }
            }
        )
    }
}

@Composable
fun ImageCell(image: PicturesEntityItemModel) {
    KamelImage(
        asyncPainterResource("https://sebastianaigner.github.io/demo-image-api/${image.path}"),
        contentDescription = "${image.category} by ${image.author}",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize().padding(5.dp)
    )
}
