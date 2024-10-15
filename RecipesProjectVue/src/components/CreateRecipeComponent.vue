<script setup>
import { useRecipesStore } from "@/stores/Recipes";
import { ref } from "vue";
const recipeStore = useRecipesStore();

const recipe = ref({
  name: '',
  ingredients: '',
  instructions: '',
  image: '',
  vegetarian: ''
})

function createRecipe() {
  recipeStore.createRecipe(recipe.value);
}
</script>

<template>
  <form @submit.prevent="createRecipe" action="">
    <label for="name">Name</label>
    <input type="text" id="name" v-model="recipe.name" required>

    <label for="ingredients">Ingredients</label>
    <input type="text" id="ingredients" v-model="recipe.ingredients" required>

    <label for="instructions">Instructions</label>
    <textarea id="instructions" v-model="recipe.instructions" required></textarea>

    <label for="image">Image URL</label>
    <input type="url" id="image" v-model="recipe.image" required> 

    <label for="minutes">Minutes</label>
    <input type="number" id="minutes" v-model="recipe.minutes" min="1" step="1" required>

    <label for="numIngredients">Number of Ingredients</label>
    <input type="number" id="numIngredients" v-model="recipe.numIngredients" min="1" step="1" required>

    <label for="servings">Servings</label>
    <input type="number" id="servings" v-model="recipe.servings" min="1" step="1" required>

    <div class="form-group dietary-preference">
        <label>Dietary Preference:</label>
        <div class="radio-group">
          <div class="isVegetarian">
            <input type="radio" id="vegetarian" value="VEGETARIAN" v-model="recipe.vegetarian">
            <label for="vegetarian">Vegetarian</label>
          </div>
          <div class="isntVegetarian">
            <input type="radio" id="nonVegetarian" value="NO_VEGETARIAN" v-model="recipe.vegetarian">
            <label for="noVegetarian">No Vegetarian</label>
          </div>
        </div>
      </div>

    <label for="madeBy">Made by</label>
    <input type="text" id="madeBy" v-model="recipe.madeBy" required>
    <button type="submit">Create recipe</button>
  </form>
</template>

<style scoped>
h1, h2, h3, h4, h5, p{
  color:#555;
}

.form-container {
    max-width: 400px;
    margin: 4rem auto;
    padding: 2rem;
    border-radius: 10px;
    background-color: #f9f9f9;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    margin-bottom: 2rem;
    font-size: 2rem;
    color: #555;
}

.form-group {
    margin-bottom: 1.5rem;
}

label {
    display: block;
    margin-bottom: 0.5rem;
    color: #555;
}

input, textarea {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1rem;
    color: #333;
}

input:focus, textarea:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

button {
    background-color: #007bff;
    border: none;
    color: white;
    padding: 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 1rem;
    margin-top: 1rem;
    cursor: pointer;
    border-radius: 5px;
    transition: background-color 0.3s ease;
    width: 100%;
}

button:hover {
    background-color: #0056b3;
}

.dietary-preference {
  margin-top: 1rem;
  text-align: center;
}

.radio-group {
  display: flex;
  justify-content: center;
  gap: 1rem;
}

.radio-group div {
  display: flex;
  align-items: center;
}

.radio-group input {
  margin-right: 0.5rem;
}

@media (max-width: 600px) {
  .form-container {
    padding: 1rem;
  }

  h2 {
    font-size: 1.5rem;
  }

  input, textarea {
    font-size: 0.9rem;
  }

  button {
    font-size: 0.9rem;
  }
}
</style>
