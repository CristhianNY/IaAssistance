package entity

import domain.example.model.PicturesEntityItemModel
import kotlinx.serialization.Serializable

@Serializable
data class PicturesEntityItemEntity(
    val author: String,
    val category: String,
    val path: String
)

fun PicturesEntityItemEntity.toModel() = PicturesEntityItemModel(author, category, path)