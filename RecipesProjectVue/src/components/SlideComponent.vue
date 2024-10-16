<script setup>
const props = defineProps({
    recipes: {
      type: Object,
      required: true,
    },
    user: {
      type: Object,
      required: false
    }
});

</script>


<template>
  <figure>
    <div>
      <img class="fixed" :src="props.recipes.image" :alt="props.recipes.name" />
    </div>
    <figcaption>
    <span class="credit">{{ props.recipes.name }}</span>
    <p class="recipe-metadata">
        <span class="recipe-rating">★★★★<span>☆</span></span>
        <span class="recipe-votes">(12 votes)</span>
    </p>
    <RouterLink :to="`/details/${props.recipes.recipe_id}`">
      <button >View Recipe</button>
    </RouterLink>
    </figcaption>
  </figure>
</template>

<style scoped>
h1, h2, h3, h4, h5, p, span{
  color:#555;
  font-size: 1rem;
}

figcaption {
  /* align-self: flex-end;
  padding: 20px 20px 0 20px;
  flex: 0 0 auto;
  width: 25%;
  min-width: 150px; */
  align-self: flex-end;
  padding: 20px;
  flex: 0 0 auto;
  width: 100%;
  max-width: 300px;
}

figure {
  display: flex;
  margin: 0;
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

.fixed{
  height: 500px;
  width: 850px;
}

@media (max-width: 768px) {
  figcaption {
    width: 100%; 
  }

  .recipe-rating {
    font-size: 0.9rem; 
  }

  .recipe-votes {
    font-size: 0.9rem; 
  }

  button {
    font-size: 14px; 
  }
  .fixed{
  height: 500px;
  width: 850px;
  transform: translateX(-80px);
}
}

@media (max-width: 480px) {
  h1, h2, h3, h4, h5, p {
    font-size: 0.9rem; 
  }

  button {
    padding: 8px; 
  }
}
</style>
