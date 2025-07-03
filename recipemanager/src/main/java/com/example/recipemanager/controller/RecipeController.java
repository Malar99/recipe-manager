package com.example.recipemanager.controller;

import com.example.recipemanager.model.Recipe;
import com.example.recipemanager.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // Homepage - All Recipes
    @GetMapping
    public String getAllRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }

    // Search Recipes
    @GetMapping("/search")
    public String searchRecipes(@RequestParam String keyword, Model model) {
        model.addAttribute("recipes", recipeService.searchRecipes(keyword));
        return "index";
    }

    // View Single Recipe
    @GetMapping("/{id}")
    public String getRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "recipe-details";
    }

    // Add New Recipe (Form)
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "add-recipe";
    }

    // Save New Recipe
    @PostMapping("/add")
    public String addRecipe(@ModelAttribute Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/recipes";
    }

    // Delete Recipe
    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable String id) {
        recipeService.deleteRecipe(id);
        return "redirect:/recipes";
    }
}