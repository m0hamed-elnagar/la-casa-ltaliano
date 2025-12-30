package com.appventure.la.casa.data.firebase

import android.util.Log
import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.data.firebase.dto.ToppingDto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlinx.serialization.json.Json

class MenuRemoteDataSource(
    private val firestore: FirebaseFirestore,
) {
    suspend fun getPizzaMenu(): List<PizzaDto> {
        return try {
            val snapshot = firestore
                .collection("pizza_menu")          // <-- or "menus/pizzas_v1"
                .get()
                .await()                       // makes the call suspend

            snapshot.map { it.toObject(PizzaDto::class.java) }
        } catch (e: Exception) {
            Log.d("menu", "Error getting documents: ", e)
            emptyList()                        // or `throw e` if you want caller to handle it
        }
}
    suspend fun getPizzaSizes(): List<PizzaSizeDto> {
        return try {
            val snapshot = firestore
                .collection("pizza_sizes")          // <-- or "menus/pizzas_v1"
                .get()
                .await()                       // makes the call suspend

            snapshot.map { it.toObject(PizzaSizeDto::class.java) }
        } catch (e: Exception) {
            Log.d("menu", "Error getting documents: ", e)
            emptyList()                        // or `throw e` if you want caller to handle it
        }
}
    suspend fun getToppings(): List<ToppingDto> {
        return try {
            val snapshot = firestore
                .collection("toppings")          // <-- or "menus/pizzas_v1"
                .get()
                .await()                       // makes the call suspend

            snapshot.map { it.toObject(ToppingDto::class.java) }
        } catch (e: Exception) {
            Log.d("menu", "Error getting documents: ", e)
            emptyList()                        // or `throw e` if you want caller to handle it
        }
}

}