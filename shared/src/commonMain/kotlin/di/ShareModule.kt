package di

import data.example.ExampleDataSource
import data.example.ExampleDataSourceImpl
import domain.example.ExampleRepository
import domain.example.ExampleRepositoryImpl
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.named
import org.koin.core.module.dsl.withOptions
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import screens.HomeViewModel

val sharedModule = module {
    single<ExampleDataSource> {
        ExampleDataSourceImpl()
    }.withOptions {
        createdAtStart()
        named("ExampleDataSource")
    }
    single<ExampleRepository> {
        ExampleRepositoryImpl(exampleDataSource = get(qualifier("ExampleDataSource")))
    }.withOptions {
        createdAtStart()
        named("ExampleRepository")
    }
    single {
        HomeViewModel(exampleRepository = get(qualifier("ExampleRepository")))
    }
}