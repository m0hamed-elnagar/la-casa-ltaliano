package com.appventure.la.casa.ui.models_ui

import com.appventure.la.casa.domain.models.PizzaCategory

data class Banner(
    val badge: String,
    val title: String,
    val buttonTitle: PizzaCategory,
    val image: String
)
