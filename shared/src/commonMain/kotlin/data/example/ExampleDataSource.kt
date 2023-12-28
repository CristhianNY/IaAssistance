package data.example

import entity.PicturesEntityItemEntity

interface ExampleDataSource {
    suspend fun getExample(): List<PicturesEntityItemEntity>
}