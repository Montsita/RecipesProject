<script setup>
import RecipeCard from "@/components/RecipeCardComponent.vue";
import { useRecipesStore } from "@/stores/Recipes";

const recipeStore = useRecipesStore();
recipeStore.fetchRecipe()
</script>

<template>
  <section class="top-part">
    <div class="top">
      <h1>RECETAS</h1>
      <h2>Todas nuestras recetas a tu alcance</h2>
      <h3>Si solo te interesan recetas vegetarianas, pulsa este botón</h3>
      <button>Recetas vegetarianas</button>
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
    width: 50%; 
}
.container-cards{
  margin: 60px;
  margin-left: 180px;
  margin-right: 180px;
}

.space-cards {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}

h1 {
  font-size: 40px;
}

p {
  width: 80%;
  text-align: center;
}
</style>