<script setup>
import { ref } from 'vue'
  import { useRecipesStore } from "@/stores/Recipes";
  const recipeStore = useRecipesStore();

  const username = ref('')
  const pass = ref('')
  const isFormVisible = ref(false);
  
  const toggleForm = () => {
  isFormVisible.value = !isFormVisible.value;
}
</script>

<template>
  <header>
    <img src="/cookingBook.jpg" alt="Logo" class="logo"/> 
    <router-link to="/">
      <button class="links-header">HOME</button>
    </router-link>
    <router-link to="/form-user">
      <button class="links-header">REGISTER</button>
    </router-link>
    <router-link to="/list">
      <button class="links-header">OUR RECIPES</button>
    </router-link>
    <div class="logging-container">
      <form @submit.prevent="recipeStore.login(username, pass)" class="login-form">
        <div class="inputs" :class="{ 'show': isFormVisible }">
          <div class="form-group">
            <input
              type="text"
              id="username"
              name="username"
              required
              placeholder="Username"
              v-model="username"
              @focus="isFormVisible = true"
            />
          </div>
          <div class="form-group">
            <input
              type="password"
              id="password"
              name="password"
              required
              placeholder="Password"
              v-model="pass"
              @focus="isFormVisible = true"
            />
          </div>
          <button type="submit">Login</button>
        </div>
      </form>
    </div>
  </header>
</template>

<style scoped>
h1, h2, h3, h4, h5, p{
  color:#555;
}

header {
  max-height: 50px;
  background-color: rgb(108, 148, 185);
  padding: 40px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: space-around;
  align-items: center;
  margin-bottom: 30px;
}

.logo {
  max-height: 70px;
  width: auto;
  border-radius: 20px;
}

h2 {
  margin: 0;
}

nav {
  display: flex;
  gap: 20px;
}

.logging-container {
  display: flex;
  align-items: center;
}

.login-form{
  background-color: #ffffff;
  padding: 5px 15px;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  height: auto;
}

.inputs {
  display: flex;
  flex-direction: row;    
  height: 100%;
  gap: 5px;
}

label {
  margin-bottom: 5px;
}


input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 100%;  
  height: 100%;
}

button {
  background-color: rgb(108, 148, 185);
  color: white;
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

button:hover {
  background-color: rgb(90, 120, 155);
}

@media (max-width: 768px) {


  .inputs {
    margin-top: 50px;
    flex-direction: column; 
    width: 100%;
  }
}

@media (max-width: 480px) {
  button {
    padding: 8px; 
    font-size: 14px; 
  }
  
  input {
    padding: 8px; 
    font-size: 14px; 
  }
}
</style>
