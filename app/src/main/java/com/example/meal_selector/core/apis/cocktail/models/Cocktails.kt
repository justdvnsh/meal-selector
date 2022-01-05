package com.example.meal_selector.core.apis.cocktail.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Cocktails(
    @SerializedName("drinks")
    val drinks: List<Cocktail>
): Serializable

class Cocktail(
    @SerializedName("strDrink")
    val strDrink: String,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String,
    @SerializedName("idDrink")
    val idDrink: String
): Serializable