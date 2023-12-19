package entity

import kotlinx.serialization.Serializable

@Serializable
data class PicturesEntityItemEntity(
    val author: String,
    val category: String,
    val path: String
)