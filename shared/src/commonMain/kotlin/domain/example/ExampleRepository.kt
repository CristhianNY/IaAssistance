package domain.example

import domain.example.model.PicturesEntityItemModel

interface ExampleRepository {
    suspend fun getExample() : List<PicturesEntityItemModel>
}