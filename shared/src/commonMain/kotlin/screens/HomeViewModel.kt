package screens

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.example.ExampleRepository
import domain.example.model.PicturesEntityItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

data class BirdsUIState(
    val images: List<PicturesEntityItemModel> = emptyList()
)

@KoinViewModel
class HomeViewModel(private val exampleRepository: ExampleRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(BirdsUIState())
    val uiState: StateFlow<BirdsUIState> = _uiState.asStateFlow()


    fun getData() {
        viewModelScope.launch {
            val images: List<PicturesEntityItemModel> = exampleRepository.getExample()
            _uiState.update {
                it.copy(images = images)
            }
        }
    }
}