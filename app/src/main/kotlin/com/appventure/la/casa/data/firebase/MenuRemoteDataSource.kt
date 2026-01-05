package com.appventure.la.casa.data.firebase

import android.util.Log
import com.appventure.la.casa.BuildConfig
import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.data.firebase.dto.ToppingDto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class MenuRemoteDataSource(
    private val firestore: FirebaseFirestore,
) {
    suspend fun getPizzaMenu(): List<PizzaDto> {
        val snapshot = firestore
            .collection("pizza_menu")
            .get()
            .await()
        if (BuildConfig.DEBUG){
            Log.d("MenuRemoteDataSource", "getPizzaMenu: ${snapshot.size()}")
        }
        return snapshot.map { it.toObject(PizzaDto::class.java) }
    }

    suspend fun getPizzaSizes(): List<PizzaSizeDto> {
        val snapshot = firestore
            .collection("pizza_sizes")
            .get()
            .await()

        return snapshot.map { it.toObject(PizzaSizeDto::class.java) }
    }

    suspend fun getToppings(): List<ToppingDto> {
        val snapshot = firestore
            .collection("toppings")
            .get()
            .await()

        return snapshot.map { it.toObject(ToppingDto::class.java) }
    }
}