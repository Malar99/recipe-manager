package com.example.recipemanager.service;

import com.example.recipemanager.model.Recipe;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {
    private final List<Recipe> recipes = new ArrayList<>();

    // CREATE
    public Recipe addRecipe(Recipe recipe) {
        recipe.setId(UUID.randomUUID().toString());
        recipes.add(recipe);
        return recipe;
    }

    // READ ALL
    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    // READ ONE
    public Recipe getRecipeById(String id) {
        return recipes.stream()
                .filter(recipe -> recipe.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    // SEARCH
    public List<Recipe> searchRecipes(String keyword) {
        return recipes.stream()
                .filter(recipe -> recipe.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    // DELETE
    public void deleteRecipe(String id) {
        recipes.removeIf(recipe -> recipe.getId().equals(id));
    }
}