package BackRecipes.controller.impl;

import BackRecipes.model.Recipe;
import BackRecipes.model.User;
import BackRecipes.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import BackRecipes.service.impl.RecipeService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.findById(id);
        if (recipe != null) {
            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        User user = userService.findByUsername(recipe.getMadeBy().getUsername());
        recipe.setMadeBy(user);
        Recipe newRecipe = recipeService.save(recipe);
        return ResponseEntity.ok(newRecipe);
    }

    @PatchMapping("/change/{id}/{username}")
    public ResponseEntity<Recipe> change (@PathVariable String username, @PathVariable Long id, @RequestBody Recipe recipe) {
        try{
            if (id == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid recipe ID");
            }

            recipe.setRecipe_id(id);

            if (!recipe.getMadeBy().getUsername().equalsIgnoreCase(username)) {
                System.out.println(recipe.getMadeBy().getUsername());
                System.out.println(username);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // Devuelve 403 si no coincide
            }

            Optional<Recipe> change = recipeService.change(recipe);
            return change.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to change the recipe", e);
        }
    }

    @DeleteMapping("/delete/{id}/{username}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String username, @PathVariable Long id) {
        Recipe recipe = recipeService.findById(id);

        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }

        if (!recipe.getMadeBy().getUsername().equalsIgnoreCase(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // Devuelve 403 si no coincide
        }

        recipeService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
