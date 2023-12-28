package screens

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import entity.PicturesEntityItemEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class BirdsUIState(
    val images: List<PicturesEntityItemEntity> = emptyList()
)

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(BirdsUIState())
    val uiState: StateFlow<BirdsUIState> = _uiState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {

        }
    }
}