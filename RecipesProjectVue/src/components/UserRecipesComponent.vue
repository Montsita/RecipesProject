<script setup>
import { useRecipesStore } from "@/stores/Recipes";

const recipeStore = useRecipesStore();
const props = defineProps({
  recipes: {
    type: Object,
    required: true,
  }
});
</script>
<template>
<section>
    <div class="recipe-user">
      <img :src="props.recipes.image" alt="Imagen de {{ props.recipes.name }}" />
      <h2>{{ props.recipes.name }}</h2>

      <div class="options">
    
        <div class="delete">
          <img
            @click="recipeStore.deleteRecipe(props.recipes.recipe_id)"
            src="/bin.png"
            alt="bin"
            class="icon"
          />
          <p>Delete recipe</p>
        </div>
        <div class="modify">
          <RouterLink :to="`/modify/${props.recipes.recipe_id}`">
            <img src="/modify.png" alt="bin" class="icon" />
            <p>Modify recipe</p>
          </RouterLink>
        </div>
      </div>
    </div>
</section>
</template>
<style scoped>
section {
  max-width: 900px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 10px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h1 {
  color: #333;
  text-align: center;
  font-size: 40px;
  margin-bottom: 50px;
}

h3 {
  color: #333;
  margin-top: 20px;
  text-align: center;
}

button {
  background-color: rgb(108, 148, 185);
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
  display: block;
  margin: 20px auto;
  font-size: 16px;
}

button:hover {
  background-color: rgb(90, 120, 155);
}

.recipe-user {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.2);
  margin: 20px 0;
  padding: 15px;
  width: 100%;
}

.recipe-user img{
  width: 70%; 
  height: 400px; 
  object-fit: cover; 
  border-radius: 5px;
  margin-bottom: 15px;
}

h2 {
  margin: 20px 0;
  margin-bottom: 20px;
  color: #333;
  font-size: 35px;
}

.recipe-user img.icon {
 cursor: pointer; 
  transition: transform 0.2s ease; 
  width: 20%; 
  max-width: auto; 
  height: auto; 
  object-fit: cover; 
  border-radius: 5px;
  margin-bottom: 15px;
}

.icon:hover {
  transform: scale(1.1);
}

.options {
  width: 40%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.delete {
  display: flex;
  flex-direction: column;
  align-items: center;
}

a {
  text-decoration: none; 
  color: inherit; 
  display: flex;
  flex-direction: column;
  align-items: center;
}

p {
  margin-top: 5px;
  font-size: 20px;
  color: #777;
  text-align: center;
  font-weight: bold;
}

@media (max-width: 768px) {
  h1 {
    font-size: 32px; 
  }

  h2 {
    font-size: 24px; 
  }

  button {
    padding: 8px 16px; 
    font-size: 14px; 
  }

  p {
    font-size: 14px; 
  }

  .options {
    flex-direction: column;
  }
}

</style>