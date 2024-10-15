# RECIPE PROJECT VUE
# Descripción

Este proyecto es una aplicación de libro de recetas en línea que ofrece a los usuarios la posibilidad de crear, modificar y eliminar recetas de manera sencilla y accesible. Los usuarios pueden registrarse, iniciar sesión y gestionar sus recetas favoritas de manera efectiva.

La aplicación está construida con **Vue.js**, utilizando **Vue Router** para facilitar la navegación entre diferentes vistas, y **Pinia** para la gestión del estado de la aplicación. Este enfoque asegura que los usuarios tengan un control total sobre sus contenidos, permitiendo que solo puedan modificar o eliminar recetas que ellos mismos han creado.

## Funcionalidades Clave:
- **Registro/Iniciar Sesión**: Los usuarios pueden registrarse o iniciar sesión para acceder a su colección de recetas.
- **Crear Receta**: Ofrece un formulario intuitivo para que los usuarios puedan agregar nuevas recetas a su repertorio.
- **Modificar Receta**: Los usuarios pueden realizar cambios en sus recetas directamente desde su perfil.
- **Eliminar Receta**: Brinda la opción de eliminar esas recetas suyas que ya no deseen conservar.

## Arquitectura del proyecto
A continuación muestro la estructura mental antes de iniciar el proyecto:

0. **Funcionalidad**
    - Página principal
        - Registro
        - Presentación de recetas
        - Acceder a más recetas
1. **Stores**
    - RecipesStore -> API para recibir recetas
2. **Rutas y Views**
    - `/` -> HOME -> Presentación 
        - DENTRO ACCEDO A REGISTRO 
            - Aparecen mis recetas y las recetas guardadas favoritas
        - CREAR USUARIO NUEVO
    - `/list` -> LIST-RECIPES -> All recipes 
        - `/list/id/details` ACCEDO DETALLES RECIPES
        - AGREGAR O MODIFICAR RECETA
3. **Componentes**
    - Recipe Card -> F: Añadir, ocultar, borrar
    - SearchBar -> F: Filtrar y reordenar
    - Favourite recipes
    - Header y Footer

## Objetos

### Producto
El objeto producto viene definido, desde el back, por la siguiente forma: 

![alt text](image.png)

## Tecnologías Utilizadas

Este proyecto ha sido desarrollado utilizando una variedad de tecnologías y lenguajes que facilitan la creación y gestión de la aplicación de libro de recetas. A continuación, se detallan las herramientas utilizadas y su propósito:

### Frontend
- **Vue.js**: Un framework progresivo de JavaScript para construir interfaces de usuario. Permite crear aplicaciones interactivas de manera eficiente.
- **Vue Router**: Biblioteca para la navegación en aplicaciones Vue.js. Facilita la gestión de las rutas y vistas de la aplicación.
- **Pinia**: Un almacén de estado para aplicaciones Vue.js que permite gestionar el estado de la aplicación de manera reactiva y sencilla.

### Backend
- **Node.js**: Entorno de ejecución de JavaScript en el servidor que permite ejecutar código JavaScript fuera del navegador.
- **Express**: Un framework de Node.js que facilita la creación de aplicaciones web y APIs, proporcionando un conjunto robusto de características para manejar rutas y middleware.
- **JSON Web Tokens (JWT)**: Método de autenticación basado en tokens que permite a los usuarios iniciar sesión y acceder a funcionalidades protegidas de la aplicación de manera segura.

### Base de Datos
- **Base de Datos NoSQL (ej. MongoDB)**: Para almacenar las recetas y datos de usuarios. Se utiliza un enfoque flexible y escalable para manejar los datos.

### Otros
- **HTML/CSS**: Lenguajes utilizados para la estructura y el diseño de la interfaz de usuario.
- **JavaScript**: Lenguaje de programación utilizado tanto en el frontend como en el backend para manejar la lógica de la aplicación.

Estas tecnologías trabajan juntas para ofrecer una experiencia de usuario fluida y una gestión efectiva de los datos, asegurando que los usuarios puedan interactuar con la aplicación de manera intuitiva.

## FrontEnd

### Estructura del Proyecto

#### Vistas de la Aplicación
- **HomeView.vue**: Vista de bienvenida que muestra una introducción a la aplicación y un carrusel de recetas destacadas.
- **RecipeListView.vue**: Vista que muestra una lista de todas las recetas disponibles en la aplicación.
- **RecipeDetailView.vue**: Vista que muestra los detalles de una receta específica.
- **RecipeFormUserView.vue**: Vista que permite a los usuarios registrarse o iniciar sesión.
- **CreateRecipeView.vue**: Vista que permite a los usuarios crear nuevas recetas.
- **ModifyRecipeView.vue**: Vista que permite a los usuarios modificar recetas existentes.
- **UserView.vue**: Vista que muestra las recetas creadas por el usuario y opciones para modificarlas o eliminarlas.

#### Componentes
- **NavbarComponent.vue**: Componente de la barra de navegación.
- **FooterComponent.vue**: Componente del pie de página.
- **CreateRecipeComponent.vue**: Componente para crear recetas.
- **UpdateRecipeComponent.vue**: Componente para actualizar recetas.
- **SlideComponent.vue**: Componente para mostrar recetas en un carrusel.
- **RecipeCardComponent.vue**: Componente que muestra las tarjetas de recetas.

### Almacenamiento (Store)
- **Recipes Store**: Utiliza Pinia para manejar el estado de las recetas, incluyendo la creación, obtención, modificación y eliminación de recetas.

### Rutas (Router)
Las rutas de la aplicación están definidas en el archivo `router/index.js`, que incluye las siguientes:

- `/`: Ruta de inicio que carga **HomeView**.
- `/list`: Ruta que carga **RecipeListView**.
- `/details/:id`: Ruta que carga **RecipeDetailView** para ver detalles de una receta específica.
- `/form-user`: Ruta para el registro e inicio de sesión del usuario.
- `/create`: Ruta para crear una nueva receta.
- `/modify/:id`: Ruta para modificar una receta existente.
- `/user`: Ruta para mostrar las recetas del usuario.

## Backend

El backend de la aplicación está construido con **Node.js** y **Express**, y proporciona una API RESTful para gestionar las recetas y los usuarios.

### Estructura del Backend

#### API Endpoints:
- **Usuarios**:
  - `POST /api/users/register`: Registra un nuevo usuario.
  - `GET /api/users/name/:id`: Obtiene información de un usuario por su ID.
  - `POST /api/login`: Autentica a un usuario y genera un token de acceso.

- **Recetas**:
  - `GET /api/recipes`: Obtiene todas las recetas.
  - `POST /api/recipes`: Crea una nueva receta (solo para usuarios autenticados).
  - `GET /api/recipes/:id`: Obtiene los detalles de una receta específica.
  - `PATCH /api/recipes/change/:id/:username`: Modifica una receta existente (solo si fue creada por el usuario autenticado).
  - `DELETE /api/recipes/delete/:id/:username`: Elimina una receta existente (solo si fue creada por el usuario autenticado).

### Autenticación
La autenticación de usuarios se realiza a través de un sistema de tokens **JWT** (JSON Web Tokens), que permite que los usuarios inicien sesión y obtengan un token para acceder a las funcionalidades protegidas de la aplicación.

## Contribuciones
Si deseas contribuir al proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (git checkout -b nueva-funcionalidad).
3. Realiza tus cambios y haz commit (git commit -m 'Añadir nueva funcionalidad').
4. Haz push a la rama (git push origin nueva-funcionalidad).
5. Abre un Pull Request.
