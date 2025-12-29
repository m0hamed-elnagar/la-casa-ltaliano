package com.appventure.la.casa.di

import androidx.room.Room
import com.appventure.la.casa.data.firebase.MenuRemoteDataSource
import com.appventure.la.casa.data.repositoryImpl.FavPizzaRepositoryImpl
import com.appventure.la.casa.data.room.LaCasaDatabase
import com.appventure.la.casa.domain.repo.FavPizzaRepository
import com.appventure.la.casa.domain.use_cases.favPizza.FavPizzaActionsUseCase
import com.appventure.la.casa.domain.use_cases.favPizza.GetFavPizzaByIdUseCase
import com.appventure.la.casa.domain.use_cases.favPizza.GetFavPizzasForPizzaUseCase
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    single {
        Room.databaseBuilder(
            get(),
            LaCasaDatabase::class.java,
            "la_casa_db"
        ).fallbackToDestructiveMigration(false)
            .build()
    }
    singleOf(::FavPizzaRepositoryImpl)
        .bind<FavPizzaRepository>()
    single { get<LaCasaDatabase>().favPizzaDao }
    //useCases for fav pizzas
    singleOf(::FavPizzaActionsUseCase)
    singleOf(::GetFavPizzasForPizzaUseCase)
    singleOf(::GetFavPizzaByIdUseCase)
    singleOf(::GetFavPizzaByIdUseCase)
    single { Firebase.firestore }                       // Firestore instance
    single { Json { ignoreUnknownKeys = true } }        // Kotlinx-serialization
    single { MenuRemoteDataSource( get()) }
}