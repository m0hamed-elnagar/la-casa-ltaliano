package com.appventure.la.casa.di

import androidx.room.Room
import com.appventure.la.casa.data.firebase.MenuRemoteDataSource
import com.appventure.la.casa.data.repositoryImpl.FavPizzaRepositoryImpl
import com.appventure.la.casa.data.repositoryImpl.PizzaRepositoryImpl
import com.appventure.la.casa.data.room.LaCasaDatabase
import com.appventure.la.casa.domain.repo.FavPizzaRepository
import com.appventure.la.casa.domain.repo.PizzaRepository
import com.appventure.la.casa.domain.use_cases.favPizza.FavPizzaActionsUseCase
import com.appventure.la.casa.domain.use_cases.favPizza.GetFavPizzaByIdUseCase
import com.appventure.la.casa.domain.use_cases.favPizza.GetFavPizzasForPizzaUseCase
import com.appventure.la.casa.domain.use_cases.pizza.ObservePizzaUseCase
import com.appventure.la.casa.domain.use_cases.pizza.SyncPizzaUseCase
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
    singleOf(::PizzaRepositoryImpl)
        .bind<PizzaRepository>()
    single { get<LaCasaDatabase>().pizzaDao }
    //useCases for fav pizzas
    singleOf(::FavPizzaActionsUseCase)
    singleOf(::GetFavPizzasForPizzaUseCase)
    singleOf(::GetFavPizzaByIdUseCase)
    singleOf(::GetFavPizzaByIdUseCase)
    single { Firebase.firestore }
    single { Json { ignoreUnknownKeys = true } }
    singleOf(::MenuRemoteDataSource)
    singleOf(::SyncPizzaUseCase)
    singleOf(::ObservePizzaUseCase)
}