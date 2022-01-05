package com.example.meal_selector.core.apis.cocktail

import com.example.meal_selector.core.apis.cocktail.models.Cocktails
import com.example.meal_selector.core.commons.constants.Constants
import io.reactivex.Observable
import retrofit2.http.GET

interface CocktailDataProvider {
    @GET("www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail")
    fun getCocktailCategories(): Observable<Cocktails>
}