package com.appventure.la.casa.data.firebase

import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.ToppingDto
import com.appventure.la.casa.data.firebase.samples.buildSamplePizzas
import com.appventure.la.casa.data.firebase.samples.buildSampleToppings
import com.google.firebase.firestore.FirebaseFirestore

/**
 * Writes the given pizzas to `menus/pizzas_v1`.
 * Each pizza is stored with its `id` as the document key.
 */
fun writeSamplePizzasToFirestore(
    pizzas: List<PizzaDto> = buildSamplePizzas(),
    db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    val col = db.collection("pizza_menu")
    pizzas.forEach { pizza ->
        col.document(pizza.id)
            .set(pizza)
            .addOnSuccessListener { println("✅ Written: ${pizza.id}") }
            .addOnFailureListener { e -> println("❌ Failed ${pizza.id}: ${e.message}") }
    }
}


/* ==========  WRITERS  ================================================== */
fun writeSampleToppingsToFirestore(
    toppings: List<ToppingDto> = buildSampleToppings(),
    db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
    val col = db.collection("toppings")
    toppings.forEach { t ->
        col.document(t.id)
            .set(t)
            .addOnSuccessListener { println("✅ Written topping: ${t.id}") }
            .addOnFailureListener { e -> println("❌ Failed topping ${t.id}: ${e.message}") }
    }
}

//fun writeSampleSizesToFirestore(
//    sizes: List<PizzaSizeDto> = buildSampleSizes(),
//    db: FirebaseFirestore = FirebaseFirestore.getInstance()
//) {
//    val col = db.collection("pizza_sizes")
//    sizes.forEach { s ->
//        val docId = s.size
//        col.document(docId)
//            .set(s)
//            .addOnSuccessListener { println("✅ Written size: $docId") }
//            .addOnFailureListener { e -> println("❌ Failed size $docId: ${e.message}") }
//    }
//}
