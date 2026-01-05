package com.appventure.la.casa.data.firebase.samples

import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.data.firebase.dto.ToppingDto

/* ==========  SAMPLE TOPPINGS  =========================================== */
fun buildSampleToppings(): List<ToppingDto> = listOf(
    ToppingDto(
        "tomato_sauce", "Tomato sauce", 0, true,
        "https://example.com/toppings/tomato_sauce.jpg"
    ),
    ToppingDto(
        "mozzarella", "Mozzarella", 150, true,
        "https://example.com/toppings/mozzarella.jpg"
    ),
    ToppingDto(
        "basil", "Basil", 50, true,
        "https://example.com/toppings/basil.jpg"
    ),
    ToppingDto(
        "pepperoni", "Pepperoni", 200, true,
        "https://example.com/toppings/pepperoni.jpg"
    ),
    ToppingDto(
        "ham", "Ham", 180, true,
        "https://example.com/toppings/ham.jpg"
    ),
    ToppingDto(
        "pineapple", "Pineapple", 120, true,
        "https://example.com/toppings/pineapple.jpg"
    ),
    ToppingDto(
        "zucchini", "Zucchini", 100, true,
        "https://example.com/toppings/zucchini.jpg"
    ),
    ToppingDto(
        "bell_peppers", "Bell peppers", 90, true,
        "https://example.com/toppings/bell_peppers.jpg"
    ),
    ToppingDto(
        "red_onion", "Red onion", 70, true,
        "https://example.com/toppings/red_onion.jpg"
    ),
    ToppingDto(
        "olives", "Olives", 80, true,
        "https://example.com/toppings/olives.jpg"
    ),
    ToppingDto(
        "gorgonzola", "Gorgonzola", 220, true,
        "https://example.com/toppings/gorgonzola.jpg"
    ),
    ToppingDto(
        "parmesan", "Parmesan", 180, true,
        "https://example.com/toppings/parmesan.jpg"
    ),
    ToppingDto(
        "provolone", "Provolone", 190, true,
        "https://example.com/toppings/provolone.jpg"
    ),
    ToppingDto(
        "white_sauce", "White sauce", 0, true,
        "https://example.com/toppings/white_sauce.jpg"
    ),
    ToppingDto(
        "feta", "Feta", 160, true,
        "https://example.com/toppings/feta.jpg"
    ),
    ToppingDto(
        "garlic", "Garlic", 40, true,
        "https://example.com/toppings/garlic.jpg"
    ),
    ToppingDto(
        "jalapenos", "Jalapeños", 60, true,
        "https://example.com/toppings/jalapenos.jpg"
    ),
    ToppingDto(
        "cherry_tomatoes", "Cherry tomatoes", 90, true,
        "https://example.com/toppings/cherry_tomatoes.jpg"
    ),
    ToppingDto(
        "bacon", "Bacon", 250, true,
        "https://example.com/toppings/bacon.jpg"
    ),
    ToppingDto(
        "arugula", "Arugula", 70, true,
        "https://example.com/toppings/arugula.jpg"
    ),
    ToppingDto(
        "truffle_oil", "Truffle oil", 150, true,
        "https://example.com/toppings/truffle_oil.jpg"
    ),
    ToppingDto(
        "walnuts", "Walnuts", 120, true,
        "https://example.com/toppings/walnuts.jpg"
    ),
    ToppingDto(
        "hot_honey", "Hot honey", 80, true,
        "https://example.com/toppings/hot_honey.jpg"
    ),
    ToppingDto(
        "artichoke", "Artichoke", 130, true,
        "https://example.com/toppings/artichoke.jpg"
    ),
    ToppingDto(
        "spinach", "Spinach", 60, true,
        "https://example.com/toppings/spinach.jpg"
    )
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
        id = "custom_pizza",
        name = "Build Your Own Pizza",
        description = "Start Building",
        rating = 5,
        offerTitle = "Create your perfect pizza from scratch!",
        offerPercentage = 0,
        haveBtn = true,
        category = "CLASSIC",
        basePrice = 150,
        sizes = listOf(
            PizzaSizeDto("S", 0),
            PizzaSizeDto("M", 50),
            PizzaSizeDto("L", 100)
        ),
        imageUrl = "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=600",
        defaultToppings = listOf("Tomato sauce", "Mozzarella"),
        availableToppings = listOf("Bacon", "Pepperoni", "Mushrooms", "Jalapeños", "Extra Cheese"),
        priority = 1,
        available = true,
        homeVisible = true

    ),
    PizzaDto(
        id = "double_delight",
        name = "Double Delight",
        description = "Order Now",
        rating = 4,
        offerTitle = "Buy one large pizza and get the second one at half price.",
        haveBtn = true,
        offerPercentage = 50,
        category = "CLASSIC",
        basePrice = 280,
        sizes = listOf(
            PizzaSizeDto("M", 0),
            PizzaSizeDto("L", 80)
        ),
        imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=600",
        defaultToppings = listOf("Tomato sauce", "Mozzarella", "Pepperoni"),
        availableToppings = listOf("Olives", "Green Pepper", "Onions"),
        priority = 2,
        available = true,
        homeVisible = true
    ),
    PizzaDto(
        id = "family_feast",
        name = "Family Feast",
        description = "Order Now",
        rating = 5,
        offerTitle = "Two large pizzas with your choice of 3 toppings each.",
        haveBtn = true,
        offerPercentage = 30,
        category = "CLASSIC",
        basePrice = 600,
        sizes = listOf(
            PizzaSizeDto("L", 0),
            PizzaSizeDto("XL", 150)
        ),
        imageUrl = "https://images.unsplash.com/photo-1593560704563-f176a2eb61db?w=600",
        defaultToppings = listOf("Tomato sauce", "Mozzarella", "Chicken", "BBQ Sauce"),
        availableToppings = listOf("Extra Cheese", "Corn", "Beef"),
        priority = 3,
        available = true,
        homeVisible = false
    ),
    PizzaDto(
        id = "summer_lunch",
        name = "Summer Lunch Special",
        description = "Order Now",
        rating = 4,
        offerTitle = "Medium pizza with a refreshing drink and garlic bread.",
        haveBtn = false,
        offerPercentage = 15,
        category = "CLASSIC",
        basePrice = 120,
        sizes = listOf(
            PizzaSizeDto("M", 0)
        ),
        imageUrl = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=600",
        defaultToppings = listOf("Tomato sauce", "Mozzarella", "Vegetables"),
        availableToppings = listOf("Mushroom", "Cherry tomatoes"),
        priority = 4,
        available = true,
        homeVisible = false
    ),
    PizzaDto(
        id = "garden_salad",
        name = "Fresh Garden Salad",
        description = "30% OFF on Salads",
        rating = 5,
        offerTitle = "Mix of fresh lettuce, cherry tomatoes, cucumber and special dressing.",
        haveBtn = true,
        offerPercentage = 30,
        category = "CLASSIC",
        basePrice = 85,
        sizes = listOf(
            PizzaSizeDto("Standard", 0),
            PizzaSizeDto("Large", 30)
        ),
        imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=600",
        defaultToppings = listOf("Lettuce", "Tomato", "Cucumber"),
        availableToppings = listOf("Grilled Chicken", "Feta Cheese", "Olives"),
        priority = 5,
        available = true,
        homeVisible = true
    )
)

