<script setup>

const props = defineProps({
  recipes: {
    type: Object,
    required: true,
  }
});

</script>

<template>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">  <section class="space-cards">
    <RouterLink class="routerLink" :to="`/details/${props.recipes.recipe_id}`">
      <div class="container" :style="{ backgroundImage: `url(${props.recipes.image})`}">
        <div class="overlay">
          <div class="items">
            <ul class="recipe-details">
              <li class="recipe-details-item">
                <i class="fas fa-clock fa-2x"></i>
                <span class="value">{{props.recipes.minutes}}</span>
                <span class="title">Minutes</span>
              </li>
              <li class="recipe-details-item">
                <i class="fas fa-book fa-2x"></i>
                <span class="value">5</span>
                <span class="title">Ingredients</span>
              </li>
              <li class="recipe-details-item">
                <i class="fas fa-user fa-2x"></i>
                <span class="value">{{props.recipes.servings}}</span>
                <span class="title">Servings</span>
              </li>
            </ul>
          </div>
          <div class="items head">
            <p>{{props.recipes.name}}</p>
            <hr />
          </div>
        </div>
      </div>
    </RouterLink>
  </section>
</template>

<style scoped>


.space-cards {
  display: flex;
  flex-wrap: wrap; 
  justify-content: center; 
  gap: 80px; 
  
}

.recipe-details-item{
  height: 20%;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 20px;
}

.routerLink{
  text-decoration: none;
}

.container {
  width: 400px;
    height: 400px;
    background-color: black;
    background-size: cover;
    cursor: pointer;
    -webkit-box-shadow: 0 0 5px #000;
    box-shadow: 0 0 5px #000;
    background-repeat: no-repeat;
}

.overlay {
  width: 100%;
  height: 100%;

  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 2fr 2fr 1fr;

  background: rgba(77, 77, 77, 0.9);
  color: white;
  opacity: 0;
  transition: all 0.5s;

  font-family: "Playfair Display", serif;
}

.items {
  padding-left: 20px;
  letter-spacing: 3px;
}

.head {
  font-size: 30px;
  line-height: 40px;

  transform: translateY(40px);
  transition: all 0.7s;
}
  
.head hr {
    display: block;
    width: 0;

    border: none;
    border-bottom: solid 2px;

    position: absolute;
    bottom: 0;
    left: 20px;

    transition: all 0.5s;
}

.cart {
  font-size: 12px;
  opacity: 0;
  letter-spacing: 1px;
  font-family: "Lato", sans-serif;
  transform: translateY(40px);
  transition: all 0.7s;
}

.cart i {
  font-size: 16px;
}

.container:hover .overlay {
  opacity: 1;
}

.container:hover .head {
  transform: translateY(0px);
}

.container:hover .head hr {
  width: 75px;
  transition-delay: 0.4s;
}

.container:hover .cart {
  transform: translateY(0px);
  transition-delay: 0.6s;
  opacity: 1;
}

.container img {
  max-width: 100%;
  max-height: 50%;
  background-repeat: no-repeat;
}

</style>
