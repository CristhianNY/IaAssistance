package domain.example

import data.example.ExampleDataSource
import domain.example.model.PicturesEntityItemModel
import entity.toModel
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
class ExampleRepositoryImpl(@Named("ExampleDataSource") val exampleDataSource: ExampleDataSource) :
    ExampleRepository {
    override suspend fun getExample(): List<PicturesEntityItemModel> {
        return exampleDataSource.getExample().map { it.toModel() }
    }
}