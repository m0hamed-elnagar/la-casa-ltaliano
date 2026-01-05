package com.appventure.la.casa.data.firebase.samples

import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.data.firebase.dto.ToppingDto

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
    PizzaSizeDto("S", 0),
    PizzaSizeDto("M", 200),
    PizzaSizeDto("L", 400),
    PizzaSizeDto("XL", 700),

    // Pepperoni
    PizzaSizeDto("S", 0),
    PizzaSizeDto("M", 250),
    PizzaSizeDto("L", 500),
    PizzaSizeDto("XL", 900),

    // Veggie
    PizzaSizeDto("S", 0),
    PizzaSizeDto("M", 200),
    PizzaSizeDto("L", 450),
    PizzaSizeDto("XL", 800),

    // 4-Cheese
    PizzaSizeDto("S", 0),
    PizzaSizeDto("M", 300),
    PizzaSizeDto("L", 600),
    PizzaSizeDto("XL", 1000),

    // Hawaiian
    PizzaSizeDto("S", 0),
    PizzaSizeDto("M", 200),
    PizzaSizeDto("L", 400),
    PizzaSizeDto("XL", 750)
)


/**
 * Builds some sample pizzas.
 */
fun buildSamplePizzas(): List<PizzaDto> = listOf(
    PizzaDto(
        id = "custom_pizza_01",
        name = "Build Your Own Pizza",
        description = "Choose your favorite crust and toppings",
        rating = 5,
        offerTitle = "Create your perfect pizza from scratch!",
        offerPercentage = 0,
        haveBtn = true,
        category = "Start Building",
        basePrice = 150,
        imageUrl = "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=600",
        defaultToppings = listOf("Tomato sauce", "Mozzarella"),
        availableToppings = listOf("Bacon", "Pepperoni", "Mushrooms", "Jalapeños", "Extra Cheese"),
        priority = 1,
        available = true
    ) ,
    PizzaDto(
        id = "LIMITED OFFER",
        name = "LIMITED OFFER",
        description = "Order Now",
        rating = 0,
        offerTitle = "50% off on your second pizza!",
        offerPercentage = 0,
        haveBtn = true,
        category = "Classics",
        basePrice = 999,
        imageUrl = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=500&auto=format&fit=crop&q=60",
        defaultToppings = listOf("Tomato sauce", "Mozzarella"),
        availableToppings = listOf("Bacon", "Cherry tomatoes", "Jalapeños"),
        priority = 2,
        available = true
    ),
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
        featured = true
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
        defaultToppings = listOf(
            "Tomato sauce",
            "Mozzarella",
            "Zucchini",
            "Bell peppers",
            "Red onion",
            "Olives"
        ),
        availableToppings = listOf("Feta", "Artichoke", "Spinach"),
        priority = 8,
        rating = 3,
        offerTitle = "Special offer",
        haveBtn = false,
        offerPercentage = 20,
        sizes = listOf(
            PizzaSizeDto("S", 20),
            PizzaSizeDto("M", 25)),
        featured = false,
        available = true,
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
        featured = true
    ),
    PizzaDto(
        id = "hawaiian",
        name = "Hawaiian",
        description = "Tomato sauce, mozzarella, ham, pineapple chunks.",
        rating = 4,
        offerTitle = "Special offer",
        haveBtn = true,
        offerPercentage = 20,
        category = "Classics",
        basePrice = 999,
        sizes = listOf(
            PizzaSizeDto("S", 0),
            PizzaSizeDto("M", 200)
        ),
        imageUrl = "https://example.com/images/hawaiian.jpg",
        defaultToppings = listOf("Tomato sauce", "Mozzarella", "Ham", "Pineapple"),
        availableToppings = listOf("Bacon", "Cherry tomatoes", "Jalapeños"),
        priority = 6,
        available = true,
        featured = false
    )
)

