package com.appventure.la.casa.data.firebase

import com.appventure.la.casa.data.firebase.dto.MenuDocument
import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.data.firebase.dto.ToppingDto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

class MenuRemoteDataSource(
    private val firestore: FirebaseFirestore,
    private val json: Json = Json { ignoreUnknownKeys = true }
) {

    suspend fun getMenuVersion(): Int =
        firestore.document("menus/v1").get().await()
            .getLong("version")?.toInt() ?: 0

    suspend fun fetchMenuTriple(): Triple<List<ToppingDto>, List<PizzaDto>, List<PizzaSizeDto>> {
        val snap = firestore.document("menus/v1").get().await()
        val doc = json.decodeFromString<MenuDocument>(snap.getString("data")!!)

        val list = doc.data
        val toppings = list.filter { it.containsKey("price") }
            .map { json.decodeFromJsonElement<ToppingDto>(it) }
        val pizzas = list.filter { it.containsKey("basePrice") }
            .map { json.decodeFromJsonElement<PizzaDto>(it) }
        val sizes = list.filter { it.containsKey("pizzaId") }
            .map { json.decodeFromJsonElement<PizzaSizeDto>(it) }

        return Triple(toppings, pizzas, sizes)
    }
}