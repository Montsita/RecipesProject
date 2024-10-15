package BackRecipes.service.impl;


import BackRecipes.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import BackRecipes.repository.RecipeRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> change(Recipe recipe)  {
        if (recipeRepository.existsById(recipe.getRecipe_id())) {
            return Optional.of(recipeRepository.save(recipe));
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
            recipeRepository.deleteById(id);
    }
}
