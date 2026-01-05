package com.appventure.la.casa.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.appventure.la.casa.data.firebase.MenuRemoteDataSource
import com.appventure.la.casa.data.local.datastore.AppPreferences
import com.appventure.la.casa.data.local.datastore.dataStore
import com.appventure.la.casa.data.local.room.LaCasaDatabase
import com.appventure.la.casa.data.repositoryImpl.FavPizzaRepositoryImpl
import com.appventure.la.casa.data.repositoryImpl.PizzaRepositoryImpl
import com.appventure.la.casa.data.repositoryImpl.SyncRepositoryImpl
import com.appventure.la.casa.domain.repo.FavPizzaRepository
import com.appventure.la.casa.domain.repo.PizzaRepository
import com.appventure.la.casa.domain.repo.SyncRepository
import com.appventure.la.casa.domain.use_cases.favPizza.FavPizzaActionsUseCase
import com.appventure.la.casa.domain.use_cases.favPizza.GetFavPizzaByIdUseCase
import com.appventure.la.casa.domain.use_cases.favPizza.GetFavPizzasForPizzaUseCase
import com.appventure.la.casa.domain.use_cases.pizza.ObservePizzaUseCase
import com.appventure.la.casa.domain.use_cases.sync.ObserveTargetUseCase
import com.appventure.la.casa.domain.use_cases.sync.SyncTargetIfNeededUseCase
import com.appventure.la.casa.ui.screens.HomeVM
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
//    //workmanager
//    factory { (ctx: Context, params: WorkerParameters) ->
//        PizzaSyncWorker(ctx, params, get())
//    }
    //dataStore
    single<DataStore<Preferences>> { androidContext().dataStore }
    single { AppPreferences(get()) }
    //room
    single {
        Room.databaseBuilder(
            get(),
            LaCasaDatabase::class.java,
            "la_casa_db"
        ).build()
    }
    //repo
    singleOf(::FavPizzaRepositoryImpl)
        .bind<FavPizzaRepository>()
    singleOf(::SyncRepositoryImpl)
        .bind<SyncRepository>()
    //dao
    single { get<LaCasaDatabase>().favPizzaDao }
    singleOf(::PizzaRepositoryImpl)
        .bind<PizzaRepository>()
    single { get<LaCasaDatabase>().pizzaDao }
    //useCases
    singleOf(::FavPizzaActionsUseCase)
    singleOf(::GetFavPizzasForPizzaUseCase)
    singleOf(::GetFavPizzaByIdUseCase)
    singleOf(::GetFavPizzaByIdUseCase)
    singleOf(::MenuRemoteDataSource)
    singleOf(::SyncTargetIfNeededUseCase)
    singleOf(::ObservePizzaUseCase)
    singleOf(::ObserveTargetUseCase)
    viewModelOf(::HomeVM)

    single { Firebase.firestore }
    single { Json { ignoreUnknownKeys = true } }
}