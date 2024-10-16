<script setup>
import { RouterLink } from 'vue-router';
</script>

<template>
  <footer>
  <div class="footer-container">
    <div class="footer-section links">
      <h3>Quick Links</h3>
      <ul>
        <li><RouterLink to="/">Home</RouterLink></li>
        <li><RouterLink to="/list">All Recipes</RouterLink></li>
        <li><RouterLink to="/create">Create Recipe</RouterLink></li>
        <li><RouterLink to="/user">My Recipes</RouterLink></li>
      </ul>
    </div>
    
    <div class="imageLogo">
      <img src="/cookingBook.jpg" alt="Logo" class="logo"/> 
      <div class="footer-bottom">
    <p>&copy; 2024 Recipe Book. All Rights Reserved.</p>
  </div>
    </div>

    <div class="footer-section contact">
      <h3>Contact Us</h3>
      <p>Email: contact@recipebook.com</p>
      <p>Phone: +123-456-7890</p>
      <div class="social-icons">
        <a href="https://www.linkedin.com/in/montse-cobes-orteu-31b058233/" target="_blank">
          <img src="/linkedin-icon.png" alt="LinkedIn" />
        </a>
        <a href="https://www.instagram.com/" target="_blank">
          <img class="logo" src="/instagram-icon.png" alt="Instagram" />
        </a>
      </div>
    </div>
    
  </div>

  
</footer>
</template>

<style scoped>

footer {
  margin-top: 60px;
  background-color: rgb(108, 148, 185);
  color: white;
  padding: 40px 0;
  font-family: Arial, sans-serif;

}

.footer-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

.footer-section {
  flex: 1;
  min-width: 250px;
  margin-bottom: 20px;
}

.links{
  text-align: center;
}

.contact{
  text-align: center;
}

.imageLogo{
  display: flex;
    flex-direction: column;
    align-items: center;
}

.logo {
  max-height: 70px;
  width: auto;
  border-radius: 20px;
}

.footer-bottom{
  margin-top: 40px;
  text-align: center;
}

.footer-section h3 {
  font-size: 1.5rem;
  margin-bottom: 15px;
  border-bottom: 2px solid white;
  padding-bottom: 5px;
}

.footer-section p {
  font-size: 1rem;
  line-height: 1.6;
}

.footer-section ul {
  list-style-type: none;
  padding: 0;
}

.footer-section ul li {
  margin-bottom: 10px;
}

.footer-section ul li a, 
.footer-section ul li RouterLink {
  color: white;
  text-decoration: none;
  font-size: 1rem;
  transition: color 0.3s;
}

.footer-section ul li a:hover, 
.footer-section ul li RouterLink:hover {
  color: rgba(255, 255, 255, 0.8); /* Cambia ligeramente el color al pasar el mouse */
}

.social-icons a {
  display: inline-block;
  margin-right: 15px;
}

.social-icons a img {
  width: 30px;
  height: 30px;
  filter: invert(1); /* Hace que los iconos sean blancos */
  transition: transform 0.3s;
}

.social-icons a img:hover {
  transform: scale(1.2); /* Zoom cuando se pasa el mouse sobre el icono */
}

/* Media Queries */
@media (max-width: 768px) {
  .footer-container {
    flex-direction: column;
    align-items: center;
    text-align: center;
  }

  .footer-section {
    margin-bottom: 30px;
  }

  .social-icons a img {
    width: 40px;
    height: 40px;
  }
}

@media (max-width: 480px) {
  footer {
    padding: 20px 0;
  }

  .footer-section h3 {
    font-size: 1.2rem;
  }

  .footer-section p, 
  .footer-section ul li a {
    font-size: 0.9rem;
  }

  .social-icons a img {
    width: 35px;
    height: 35px;
  }
}
</style>