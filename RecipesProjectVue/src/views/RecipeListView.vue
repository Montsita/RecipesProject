<script setup>
import RecipeCard from "@/components/RecipeCardComponent.vue";
import { useRecipesStore } from "@/stores/Recipes";

const recipeStore = useRecipesStore();
recipeStore.fetchRecipe()
</script>

<template>
  <section class="top-part">
  <div class="top">
    <h1>RECIPES</h1>
    <h2>All our recipes at your fingertips</h2>
    <h3>If you are only interested in vegetarian recipes, click this button</h3>
    <button>Vegetarian Recipes</button>
  </div>
</section>

<section class="container-cards">
  <div class="space-cards">
    <RecipeCard
      v-for="recipe in recipeStore.arrayRecipes"
      :recipes="recipe"
    ></RecipeCard>
  </div>
</section>
</template>

<style scoped>
.top {
    text-align: center;
    margin-bottom: 2rem;
}

h1{
  font-size: 2.5rem;
  color: #333;
  margin-bottom: 1rem;
}

h2, h3, h4, h5, p{
  color:#555;
  line-height: 1.5;
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
    /* width: 50%;  */
    width: 100%;
    max-width: 300px;
}

.container-cards{

  margin: 60px auto;
  padding: 0 20px;
}

.space-cards {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}

h1 {
  font-size: 2.5rem;
}

p {
  width: 80%;
  text-align: center;
}

@media (max-width: 768px) {
  h1 {
    font-size: 2rem; 
  }

  h2 {
    font-size: 1.5rem; 
  }

  button {
    width: 90%; 
  }

  .container-cards {
    margin: 20px; 
  }
}

@media (max-width: 480px) {
  h1 {
    font-size: 1.5rem; 
  }

  h2 {
    font-size: 1.2rem; 
  }

  h3 {
    font-size: 1rem; 
  }

  .space-cards {
    gap: 10px; 
  }
}
</style>