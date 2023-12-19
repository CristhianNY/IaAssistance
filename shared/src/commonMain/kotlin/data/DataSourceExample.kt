package data

import entity.PicturesEntityItemEntity

interface DataSourceExample {
    suspend fun getExample(): List<PicturesEntityItemEntity>
}