package data.example

import entity.PicturesEntityItemEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Named("ExampleDataSource")
@Single
class ExampleDataSourceImpl : ExampleDataSource {

    private var httpClient: HttpClient? = null

    init {
        httpClient = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
    }


    override suspend fun getExample(): List<PicturesEntityItemEntity> {
        return httpClient?.get("https://sebi.io/demo-image-api/pictures.json")
            ?.body<List<PicturesEntityItemEntity>>() ?: emptyList()
    }
}