<script setup>
import { useRecipesStore } from "@/stores/Recipes";
import { ref } from "vue";
const recipeStore = useRecipesStore();

const user = ref({
    username: '',
    email: '',
    password: '',
})

function createUser() {
  recipeStore.registerUser(user.value);
}
</script>

<template>
  <div class="top">
    <h1>We're so glad you want to join us! 👋</h1>
    <h3>Fill out the form and submit it, and you'll be able to save your favorite recipes and create new ones in this wonderful recipe book. 
        <br>Thank you for wanting to participate <br> ❤️</h3>
  </div>
  <div class="form-container">
    <h2>Registro de Usuario</h2>
        <form @submit.prevent="createUser" id="registrationForm">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="name" name="username" v-model="user.username" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" v-model="user.email" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" v-model="user.password" required>
            </div>

            <div class="form-group">
                <button type="submit">Register</button>
            </div>

            <div class="form-message" id="formMessage"></div>
        </form>
  </div>
</template>

<style scoped>
h1, h2, h3, h4, h5, p{
  color:#555;
}

.top {
    text-align: center;
    margin-bottom: 2rem;
}

.top h1 {
    font-size: 2.5rem;
    color: #333;
}

.top h3 {
    font-size: 1.2rem;
    color: #666;
    line-height: 1.5;
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

input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1rem;
    color: #333;
}

input:focus {
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

.form-message {
    margin-top: 10px;
    text-align: center;
    color: #28a745;
    font-weight: bold;
}
</style>