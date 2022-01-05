package com.example.meal_selector.core.apis.meal.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Meals(
    @SerializedName("categories")
    val categories: List<Meal>
): Serializable

class Meal(
    @SerializedName("idCategory")
    val idCategory: String,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String
): Serializable