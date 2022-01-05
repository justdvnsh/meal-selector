package com.example.meal_selector.core.repositories.cocktails

import com.example.meal_selector.core.apis.cocktail.CocktailDataProvider
import com.example.meal_selector.core.apis.cocktail.models.Cocktail
import com.example.meal_selector.core.apis.cocktail.models.Cocktails
import io.reactivex.Observable

class DefaultCocktailRepository(
    private val cocktailDataProvider: CocktailDataProvider
): CocktailRepository {
    override fun getCocktails(): Observable<Cocktails> {
        TODO("Not yet implemented")
    }

    override fun getSingleCocktailDetails(cocktailId: String): Observable<Cocktail> {
        TODO("Not yet implemented")
    }
}