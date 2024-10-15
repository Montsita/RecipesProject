<script setup>
import { ref, watch } from "vue";
import { useRecipesStore } from "@/stores/Recipes";
import { useRoute } from "vue-router";

const route = useRoute();

const recipeStore = useRecipesStore();

watch(
  () => route.params.id,
   () => {
    recipeStore.fetchRecipeUser(route.params.id);
  },
  { immediate: true } 
);

recipeStore.fetchRecipeUser(route.params.id);
</script>

<template>
  <link
  rel="stylesheet"
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
  />
  <h1>Modify your recipe here</h1>
  
  <div class="recipeEspecific" v-if="recipeStore.recipeEspecific">
    <img
      :src="recipeStore.recipeEspecific.image"
      alt="Imagen de {{ recipeStore.recipeEspecific.name }}"
    />
    <input v-model="recipeStore.recipeEspecific.name" class="input value">
    

    <p v-if="recipeStore.recipeEspecific.madeBy?.name">by: <input v-model="recipeStore.recipeEspecific.madeBy.name" class="input value"></p>
    
    <p></p>
    <div class="items">
        <ul class="recipe-details">
          <li class="recipe-details-item">
            <i class="fas fa-clock fa-2x"></i>
            <div class="info">
              <input v-model="recipeStore.recipeEspecific.minutes" class="input value">
              <span class="title">Minutes</span>
            </div>
          </li>
          <li class="recipe-details-item">
            <i class="fas fa-book fa-2x"></i>
            <div class="info">
              <input v-model="recipeStore.recipeEspecific.numIngredients" class="input value">
              <span class="title">Ingredients</span>
            </div>
          </li>
          <li class="recipe-details-item">
            <i class="fas fa-user fa-2x"></i>
            <div class="info">
              <input v-model="recipeStore.recipeEspecific.servings" class="input value">
              <span class="title">Servings</span>
            </div>
          </li>
        </ul>
      </div>
    <h4>Ingredients</h4>
    <input v-model="recipeStore.recipeEspecific.ingredients" class="input value">

    <h4 class="instructions">Instructions</h4>
    <textarea v-model="recipeStore.recipeEspecific.instructions" class="input value"></textarea>
    

    <div class="buttons-container">
      <button @click="recipeStore.saveChanges()" class="return-button">Save changes</button>
    </div>
  </div>
</template>

<style scoped>
.recipeEspecific {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  max-width: 600px;
  margin: 2rem auto;
  padding: 2rem;
  border-radius: 10px;
  background-color: #f9f9f9;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.recipeEspecific img {
  width: 100%;
  height: auto;
  max-height: 400px;
  object-fit: cover;
  border-radius: 10px;
  margin-bottom: 1.5rem;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.recipe-details {
  display: flex; 
  justify-content: space-evenly;
  align-items: center;
  list-style: none; 
  padding: 0;
  margin: 0;
  margin-bottom: 1rem;
}

.recipe-details-item {
  display: flex; 
  flex-direction: column; 
  align-items: center; 
  text-align: center;
  margin: 0 15px;
}

div.items {
  width: 100%;
}
.recipe-details-item i {
  color: #555;
  margin-bottom: 8px;
}

.info {
  display: flex;
  flex-direction: column;
  color: #555;
}

.input {
  width: 100%;
  padding: 10px;
  margin-bottom: 1rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
}

textarea.input {
  height: 150px;
  resize: vertical;
}

.value {
  font-size: 18px; 
}

h1{
  margin-bottom: 3rem;
  font-size: 2rem;
  color: #555;
  text-align: center;
}

.recipeEspecific h2 {
  margin-bottom: 3rem;
  font-size: 2rem;
  color: #555;
  text-align: center;
}

.recipeEspecific h4 {
  font-size: 1.4rem;
  color: #555;
  margin-top: 1rem;
  margin-bottom: 0.5rem;
  text-align: left;
  width: 100%;
}


.recipeEspecific p {
  font-size: 1.1rem;
  color: #666;
  line-height: 1.6;
  text-align: justify;
  width: 100%;
  margin-bottom: 1.5rem;
  text-align: ce;
}

.buttons-container{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  width: 100%;
}

button {
  background-color: #007bff;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 10px 0;
  cursor: pointer;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: #0056b3;
}

@media (max-width: 768px) {
  .RecipeEspecific {
    padding: 1rem;
  }

  .RecipeEspecific img {
    max-height: 300px;
  }

  .RecipeEspecific h2 {
    font-size: 1.6rem;
  }

  .RecipeEspecific h4 {
    font-size: 1.2rem;
  }

  .RecipeEspecific p {
    font-size: 1rem;
  }
}
</style>
