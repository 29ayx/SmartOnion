// package com.smartonion.salt.service.MealPlansService;

// import com.smartonion.salt.model.MealPlans.Recipe;
// import com.smartonion.salt.repository.MealPlansRepo.RecipeRepo;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class RecipeService {

//     @Autowired
//     private RecipeRepo recipeRepo;

//     // CRUD Methods

//     public Recipe createRecipe(Recipe recipe) {
//         return recipeRepo.save(recipe);
//     }

//     public List<Recipe> getAllRecipes() {
//         return recipeRepo.findAll();
//     }

//     public Optional<Recipe> getRecipeById(String recipeId) {
//         return recipeRepo.findById(recipeId);
//     }

//     public Recipe updateRecipe(Recipe recipe) {
//         return recipeRepo.save(recipe);
//     }

//     public void deleteRecipe(String recipeId) {
//         recipeRepo.deleteById(recipeId);
//     }
// }

