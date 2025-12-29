package com.appventure.la.casa.data.firebase.samples

import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.data.firebase.dto.ToppingDto
import com.google.firebase.firestore.FirebaseFirestore

/* ==========  SAMPLE TOPPINGS  =========================================== */
fun buildSampleToppings(): List<ToppingDto> = listOf(
    ToppingDto("tomato_sauce", "Tomato sauce", 0, true,
        "https://example.com/toppings/tomato_sauce.jpg"),
    ToppingDto("mozzarella", "Mozzarella", 150, true,
        "https://example.com/toppings/mozzarella.jpg"),
    ToppingDto("basil", "Basil", 50, true,
        "https://example.com/toppings/basil.jpg"),
    ToppingDto("pepperoni", "Pepperoni", 200, true,
        "https://example.com/toppings/pepperoni.jpg"),
    ToppingDto("ham", "Ham", 180, true,
        "https://example.com/toppings/ham.jpg"),
    ToppingDto("pineapple", "Pineapple", 120, true,
        "https://example.com/toppings/pineapple.jpg"),
    ToppingDto("zucchini", "Zucchini", 100, true,
        "https://example.com/toppings/zucchini.jpg"),
    ToppingDto("bell_peppers", "Bell peppers", 90, true,
        "https://example.com/toppings/bell_peppers.jpg"),
    ToppingDto("red_onion", "Red onion", 70, true,
        "https://example.com/toppings/red_onion.jpg"),
    ToppingDto("olives", "Olives", 80, true,
        "https://example.com/toppings/olives.jpg"),
    ToppingDto("gorgonzola", "Gorgonzola", 220, true,
        "https://example.com/toppings/gorgonzola.jpg"),
    ToppingDto("parmesan", "Parmesan", 180, true,
        "https://example.com/toppings/parmesan.jpg"),
    ToppingDto("provolone", "Provolone", 190, true,
        "https://example.com/toppings/provolone.jpg"),
    ToppingDto("white_sauce", "White sauce", 0, true,
        "https://example.com/toppings/white_sauce.jpg"),
    ToppingDto("feta", "Feta", 160, true,
        "https://example.com/toppings/feta.jpg"),
    ToppingDto("garlic", "Garlic", 40, true,
        "https://example.com/toppings/garlic.jpg"),
    ToppingDto("jalapenos", "Jalapeños", 60, true,
        "https://example.com/toppings/jalapenos.jpg"),
    ToppingDto("cherry_tomatoes", "Cherry tomatoes", 90, true,
        "https://example.com/toppings/cherry_tomatoes.jpg"),
    ToppingDto("bacon", "Bacon", 250, true,
        "https://example.com/toppings/bacon.jpg"),
    ToppingDto("arugula", "Arugula", 70, true,
        "https://example.com/toppings/arugula.jpg"),
    ToppingDto("truffle_oil", "Truffle oil", 150, true,
        "https://example.com/toppings/truffle_oil.jpg"),
    ToppingDto("walnuts", "Walnuts", 120, true,
        "https://example.com/toppings/walnuts.jpg"),
    ToppingDto("hot_honey", "Hot honey", 80, true,
        "https://example.com/toppings/hot_honey.jpg"),
    ToppingDto("artichoke", "Artichoke", 130, true,
        "https://example.com/toppings/artichoke.jpg"),
    ToppingDto("spinach", "Spinach", 60, true,
        "https://example.com/toppings/spinach.jpg")
)

/* ==========  SAMPLE SIZES  ============================================= */
fun buildSampleSizes(): List<PizzaSizeDto> = listOf(
    // Margherita
    PizzaSizeDto("margherita_classic", "S", 0),
    PizzaSizeDto("margherita_classic", "M", 200),
    PizzaSizeDto("margherita_classic", "L", 400),
    PizzaSizeDto("margherita_classic", "XL", 700),

    // Pepperoni
    PizzaSizeDto("pepperoni_feast", "S", 0),
    PizzaSizeDto("pepperoni_feast", "M", 250),
    PizzaSizeDto("pepperoni_feast", "L", 500),
    PizzaSizeDto("pepperoni_feast", "XL", 900),

    // Veggie
    PizzaSizeDto("veggie_delight", "S", 0),
    PizzaSizeDto("veggie_delight", "M", 200),
    PizzaSizeDto("veggie_delight", "L", 450),
    PizzaSizeDto("veggie_delight", "XL", 800),

    // 4-Cheese
    PizzaSizeDto("four_cheese", "S", 0),
    PizzaSizeDto("four_cheese", "M", 300),
    PizzaSizeDto("four_cheese", "L", 600),
    PizzaSizeDto("four_cheese", "XL", 1000),

    // Hawaiian
    PizzaSizeDto("hawaiian", "S", 0),
    PizzaSizeDto("hawaiian", "M", 200),
    PizzaSizeDto("hawaiian", "L", 400),
    PizzaSizeDto("hawaiian", "XL", 750)
)


/**
 * Builds some sample pizzas.
 */
fun buildSamplePizzas(): List<PizzaDto> = listOf(
    PizzaDto(
        id = "margherita_classic",
        name = "Margherita Classic",
        description = "San-Marzano tomato, fresh mozzarella, basil, EVOO.",
        category = "Classics",
        basePrice = 899,
        imageUrl = "https://example.com/images/margherita.jpg",
        defaultToppings = listOf("Tomato sauce", "Mozzarella", "Basil"),
        availableToppings = listOf("Extra mozzarella", "Cherry tomatoes", "Garlic"),
        priority = 10,
        isFeatured = true
    ),
    PizzaDto(
        id = "pepperoni_feast",
        name = "Pepperoni Feast",
        description = "Double portion of spicy pepperoni on our classic tomato base.",
        category = "Meat lovers",
        basePrice = 1199,
        imageUrl = "https://example.com/images/pepperoni.jpg",
        defaultToppings = listOf("Tomato sauce", "Mozzarella", "Pepperoni"),
        availableToppings = listOf("Hot honey", "Jalapeños", "Olives"),
        priority = 9
    ),
    PizzaDto(
        id = "veggie_delight",
        name = "Veggie Delight",
        description = "Grilled zucchini, bell peppers, red onion, olives, tomato sauce.",
        category = "Vegetarian",
        basePrice = 1050,
        imageUrl = "https://example.com/images/veggie.jpg",
        defaultToppings = listOf("Tomato sauce", "Mozzarella", "Zucchini", "Bell peppers", "Red onion", "Olives"),
        availableToppings = listOf("Feta", "Artichoke", "Spinach"),
        priority = 8
    ),
    PizzaDto(
        id = "four_cheese",
        name = "Quattro Formaggi",
        description = "Mozzarella, gorgonzola, parmesan, provolone, white sauce base.",
        category = "Cheese",
        basePrice = 1299,
        imageUrl = "https://example.com/images/4cheese.jpg",
        defaultToppings = listOf("White sauce", "Mozzarella", "Gorgonzola", "Parmesan", "Provolone"),
        availableToppings = listOf("Truffle oil", "Walnuts", "Arugula"),
        priority = 7,
        isFeatured = true
    ),
    PizzaDto(
        id = "hawaiian",
        name = "Hawaiian",
        description = "Tomato sauce, mozzarella, ham, pineapple chunks.",
        category = "Classics",
        basePrice = 999,
        imageUrl = "https://example.com/images/hawaiian.jpg",
        defaultToppings = listOf("Tomato sauce", "Mozzarella", "Ham", "Pineapple"),
        availableToppings = listOf("Bacon", "Cherry tomatoes", "Jalapeños"),
        priority = 6,
        isAvailable = true
    )
)

