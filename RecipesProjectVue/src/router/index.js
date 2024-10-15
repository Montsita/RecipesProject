import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import("../views/HomeView.vue"), 
    },
    {
      path: '/list',
      name: 'list',
      component: () => import("../views/RecipeListView.vue")
    },
    {
      path: '/details/:id',
      name: 'details',
      component: () => import("../views/RecipeDetailView.vue")
    },
    {
      path: '/form-user',
      name: 'formUser',
      component: () => import("../views/RecipeFormUserView.vue")
    },
    {
      path: '/user',
      name: 'user',
      component: () => import("../views/UserView.vue")
    },
    {
      path: '/create',
      name: 'create',
      component: () => import("../views/CreateRecipeView.vue")
    },
    {
      path: '/modify/:id',
      name: 'modify',
      component: () => import("../views/ModifyRecipeView.vue")
    }
    
  ]
})

export default router