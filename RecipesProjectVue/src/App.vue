<script setup>
import Navbar from './components/NavbarComponent.vue'
import FooterComponent from './components/FooterComponent.vue';
</script>

<template>
  <Navbar></Navbar>
  <main>
    <RouterView />
  </main>
  <FooterComponent></FooterComponent>
</template>

<style scoped>
main {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    margin: 0;
    background-color:#F4F4F4;
    flex-wrap: wrap;
}
</style>
