<script setup>
import { ref, onMounted, watch } from "vue";
import { useRecipesStore } from "@/stores/Recipes";
import SlideComponent from "@/components/SlideComponent.vue";

const recipeStore = useRecipesStore();
let recipesHome = ref([]);

async function dataLoader(){
  await recipeStore.fetchRecipe();
  listRecipesHome();
}
dataLoader()


function listRecipesHome() {
  for (let i = 0; i < 6; i++) {
    recipesHome.value.push(recipeStore.arrayRecipes[i]);
  }
}

</script>

<template>
  <section class="product-show">
    <h1>🍲Welcome to your favorite recipe book🌮</h1>
    <p>
      Welcome to our online recipe book! Here, you'll find a variety of cooking
      recipes that will help you easily organize and discover your favorite
      dishes. We hope these recipes assist you in planning and preparing your
      own weekly menus. Additionally, you can contribute to expanding this
      recipe book by sharing your best recipes! Feel free to publish them.
    </p>
    <h3>
      If you have an account, please log in to your profile.If not, we invite
      you to create one. It's completely free
    </h3>
    <RouterLink to="/form-user">
      <button >Sign up</button>
    </RouterLink>

    <section class="container">
      <h2>Recetas favoritas de esta semana</h2>
        <div class="carousel">
          <input type="radio" name="slides" checked="checked" id="slide-1" />
          <input type="radio" name="slides" id="slide-2" />
          <input type="radio" name="slides" id="slide-3" />
          <input type="radio" name="slides" id="slide-4" />
          <input type="radio" name="slides" id="slide-5" />
          <input type="radio" name="slides" id="slide-6" />
          <ul class="carousel__slides">
            <li v-for="(recipe, index) in recipesHome" :key="'slide-'+index" 
            class="carousel__slide">
              <SlideComponent :recipes="recipe" :usuario="recipe.madeBy"> 
              </SlideComponent>
            </li>
          </ul>
          <ul class="carousel__thumbnails">
            <li v-for="(slide, index) in recipesHome" 
            :key="'thumbnail-'+index">
              <label :for="'slide-' + (index + 1)">
                <img :src="slide.image" :alt="slide.name" />
              </label>
            </li>
          </ul>
        </div>
    </section>
  </section>
  <section class="all-recipes">
    <h2>Aqui puedes ver todas nuestras recetas!</h2>
    <RouterLink to="/list">
      <button >Ver más</button>
    </RouterLink>
  </section>
</template>

<style scoped>

/* carrousel */
@mixin aspect-ratio($width, $height) {
  position: relative;

  &:before {
    display: block;
    content: "";
    width: 100%;
    padding-top: ($height / $width) * 100%;
  }

  > img {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    width: 100%;
    height: 100%;
  }
}

section {
  background: #f4f4f4;
  margin: 50px 0;
}

.container {
  max-width: 1050px;
  margin-top: 0 auto;
  padding: 0 20px;
}

.carousel {
  display: block;
  text-align: left;
  margin-bottom: 22px;

  > input {
    clip: rect(1px, 1px, 1px, 1px);
    clip-path: inset(50%);
    height: 1px;
    width: 1px;
    margin: -1px;
    overflow: hidden;
    padding: 0;
    position: absolute;

    &:nth-of-type(6):checked
      ~ .carousel__slides
      .carousel__slide:first-of-type {
      margin-left: -500%;
    }
    &:nth-of-type(5):checked
      ~ .carousel__slides
      .carousel__slide:first-of-type {
      margin-left: -400%;
    }
    &:nth-of-type(4):checked
      ~ .carousel__slides
      .carousel__slide:first-of-type {
      margin-left: -300%;
    }
    &:nth-of-type(3):checked
      ~ .carousel__slides
      .carousel__slide:first-of-type {
      margin-left: -200%;
    }
    &:nth-of-type(2):checked
      ~ .carousel__slides
      .carousel__slide:first-of-type {
      margin-left: -100%;
    }
    &:nth-of-type(1):checked
      ~ .carousel__slides
      .carousel__slide:first-of-type {
      margin-left: 0%;
    }

    &:nth-of-type(1):checked ~ .carousel__thumbnails li:nth-of-type(1) {
      box-shadow: 0px 0px 0px 5px rgba(0, 0, 255, 0.5);
    }
    &:nth-of-type(2):checked ~ .carousel__thumbnails li:nth-of-type(2) {
      box-shadow: 0px 0px 0px 5px rgba(0, 0, 255, 0.5);
    }
    &:nth-of-type(3):checked ~ .carousel__thumbnails li:nth-of-type(3) {
      box-shadow: 0px 0px 0px 5px rgba(0, 0, 255, 0.5);
    }
    &:nth-of-type(4):checked ~ .carousel__thumbnails li:nth-of-type(4) {
      box-shadow: 0px 0px 0px 5px rgba(0, 0, 255, 0.5);
    }
    &:nth-of-type(5):checked ~ .carousel__thumbnails li:nth-of-type(5) {
      box-shadow: 0px 0px 0px 5px rgba(0, 0, 255, 0.5);
    }
    &:nth-of-type(6):checked ~ .carousel__thumbnails li:nth-of-type(6) {
      box-shadow: 0px 0px 0px 5px rgba(0, 0, 255, 0.5);
    }
  }
}

h1, h2, h3, h4, h5, p{
  color:#555;
}

.carousel__slides {
  padding: 0;
  margin: 0;
  overflow: hidden;
  white-space: nowrap;
  box-sizing: border-box;
  display: flex;
  align-items: flex-end;
}

.carousel__slide {
  position: relative;
  display: block;
  flex: 1 0 100%;
  width: 100%;
  height: 100%;
  overflow: hidden;
  transition: all 300ms ease-out;
  vertical-align: top;
  box-sizing: border-box;
  white-space: normal;

  figure {
    display: flex;
    margin: 0;
  }

  div {
    @include aspect-ratio(3, 2);
    width: 100%;
  }

  img { 
    display: block;
    flex: 1 1 auto;
    object-fit: cover;
    max-width: 100%;
    max-height: 100%;
    width: 100%;
    height: 100%;
  }

  figcaption {
    align-self: flex-end;
    padding: 20px 20px 0 20px;
    flex: 0 0 auto;
    width: 25%;
    min-width: 150px;
  }

  &.scrollable {
    overflow-y: scroll;
  }
}

.carousel__thumbnails {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;

  margin: 0 -10px;

  .carousel__slides + & {
    margin-top: 20px;
  }

  li {
    flex: 1 1 auto;
    max-width: calc((100% / 6) - 20px);
    margin: 0 10px;
    transition: all 300ms ease-in-out;
  }

  label {
    display: block;
    height: 100%;
    @include aspect-ratio(1, 1);

    &:hover,
    &:focus {
      cursor: pointer;

      img {
        box-shadow: 0px 0px 0px 1px rgba(0, 0, 0, 0.25);
        transition: all 300ms ease-in-out;
      }
    }
  }

  img {
    display: block;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
}

.logging-container {
  width: 40%;
  height: 20%;
  background-color: #e0f7fa; 
  border-radius: 8px; 
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 30px;
}

.login-form {
  display: flex;
  flex-direction: column;
  width: 100%;
  padding: 20px;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  margin-bottom: 5px;
  font-weight: bold;
}

input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 100%;
}

button {
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #0056b3; /* Darker blue on hover */
}

.product-show {
  display: flex;
  flex-wrap: nowrap;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}

.margin {
  margin: 10px;
}
.space-cards {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}

h1 {
  font-size: 4rem;
  margin-bottom: 3rem;
  color: #333;
}

p {
  width: 80%;
  text-align: center;
  font-size: 30px;
  margin-bottom: 3rem;
}

h3{
  font-size: 20px;
  margin-bottom: 20px;
}

.all-recipes{
  display: flex;
  flex-direction: column;
  align-items: center;
}

@media (max-width: 768px) {
  .product-show{
    width: 100%;
  }
  .product-show h1 {
    font-size: 2rem; /* Smaller font size for h1 */
  }

  .product-show p,
  .product-show h3 {
    font-size: 1rem; /* Smaller font size for text */
    padding: 0 10px; /* Add padding for better spacing */
  }

  .product-show button {
    width: 100%; /* Full width button on smaller screens */
    font-size: 1rem; /* Adjust font size for button */
  }

.container{
  width: 100%;
  height: 100%;
}

.carousel__slide {
  position: relative;
  display: block;
  flex: 1 0 100%;
  width: 100%;
  height: 100%;
  overflow: hidden;
  transition: all 300ms ease-out;
  vertical-align: top;
  box-sizing: border-box;
  white-space: normal;
}

img {
    display: block;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  }
</style>
