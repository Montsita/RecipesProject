import { ref } from "vue";
import { defineStore } from "pinia";
import router from "@/router";

export const useRecipesStore = defineStore("recipes", () => {
  const arrayRecipes = ref([]);
  const user = ref({ username: "", id: "" });

  const myRecipes = ref([]);
  const recipeEspecific = ref();

  const baseRecipesURL = "http://localhost:8080/api/recipes";
  const baseUsersURL = "http://localhost:8080/api/users";

  async function createRecipe(recipe) {
    try {
      const response = await fetch(baseRecipesURL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(recipe),
      });
      if (!response.ok) {
        throw new Error(`Error: ${response.statusText}`);
      }
      const newRecipe = await response.json();
      myRecipes.value.push(newRecipe);
      arrayRecipes.value.push(newRecipe);

      alert("Recipe created successfully!");
      router.push("/user");
    } catch (error) {
      console.error("Error creating recipes:", error);
    }
  }

  async function fetchRecipe() {
    try {
      const response = await fetch(baseRecipesURL);
      if (!response.ok) {
        throw new Error(`Error: ${response.statusText}`);
      }
      const recipes = await response.json();
      arrayRecipes.value = recipes;
    } catch (error) {
      console.error("Error fetching recipes:", error);
    }
  }

  async function fetchRecipeUser(id) {
    try {
      const response = await fetch(`${baseRecipesURL}/${id}`);
      if (!response.ok) {
        throw new Error(`Error: ${response.statusText}`);
      }
      const recipe = await response.json();

      if (!recipe.madeBy || !recipe.madeBy.user_id) {
        console.warn("La receta no tiene un campo 'madeBy' válido.");
        recipeEspecific.value = recipe;
        return;
      }

      const userResponse = await fetch(
        `${baseUsersURL}/name/${recipe.madeBy.user_id}`
      );
      if (!userResponse.ok) {
        throw new Error(`Error: ${userResponse.statusText}`);
      }
      const user = await userResponse.json();
      recipe.madeBy = user;
      recipeEspecific.value = recipe;
    } catch (error) {
      console.error("Error fetching recipe or user:", error);
    }
  }

  async function deleteRecipe(id) {
    try {
      const response = await fetch(
        `${baseRecipesURL}/delete/${id}/${user.value.username}`,
        {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      if (!response.ok) {
        throw new Error(`Error: ${response.statusText}`);
      }

      arrayRecipes.value = arrayRecipes.value.filter(
        (recipe) => recipe.recipe_id !== id
      );

      alert("The recipe was deleted successfully.");
    } catch (error) {
      console.error("Error creating recipes:", error);
    }
  }

  async function modifyRecipe(id, updatedRecipe) {
    try {
      const response = await fetch(`${baseRecipesURL}/change/${id}/${user.value.username}`, {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedRecipe),
      });
      if (!response.ok) {
        throw new Error(`Error: ${response.statusText}`);
      }

      const index = arrayRecipes.value.findIndex(
        (recipe) => recipe.recipe_id === id
      );
      if (index !== -1) {
        arrayRecipes.value[index] = updatedRecipe;
      }
    } catch (error) {
      console.error("Error creating recipes:", error);
    }
  }

  const saveChanges = async () => {
    try {
      await modifyRecipe(
        recipeEspecific.value.recipe_id,
        recipeEspecific.value
      );

      alert("Changes have been saved successfully!");

      router.push("/user");
    } catch (error) {
      console.error("Error saving changes:", error);
      alert("An error occurred while saving the changes.");
    }
  };

  async function registerUser(user) {
    try {
      const response = await fetch("http://localhost:8080/api/users/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
      });
      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.message || "Registration failed");
      }
      const data = await response.json();
      alert('Registration successful');
      router.push("/user");
    } catch (error) {
      console.error(`Error: ${error.message}`);
    }
  }

  async function login(username, password){
    try {
      const response = await fetch('http://localhost:8080/api/login' + "?username=" + username + "&password=" + password)
      if (!response.ok) {
        throw new Error('Error in the server response: ' + response.status);
      }
      const data = await response.json();

      if (data.access_token) {
        localStorage.setItem('token', data.access_token);
        
        user.value.username = username; 
        alert('Login successful');
        router.push('/user');
      } else {
        throw new Error('Token not received in the response');
      }
    } catch (error) {
      console.error(error);
      alert('Incorrect username or password');
    }
  }

  return {
    arrayRecipes,
    recipeEspecific,
    createRecipe,
    fetchRecipe,
    fetchRecipeUser,
    deleteRecipe,
    modifyRecipe,
    saveChanges,
    registerUser,
    login,
  };
});
