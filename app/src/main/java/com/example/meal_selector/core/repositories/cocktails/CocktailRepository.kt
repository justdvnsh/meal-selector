package com.example.meal_selector.core.repositories.cocktails

import com.example.meal_selector.core.apis.cocktail.models.Cocktail
import com.example.meal_selector.core.apis.cocktail.models.Cocktails
import io.reactivex.Observable

interface CocktailRepository {
    fun getCocktails(): Observable<Cocktails>
    fun getSingleCocktailDetails(
        cocktailId: String
    ): Observable<Cocktail>
}