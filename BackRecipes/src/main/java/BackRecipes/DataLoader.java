
package BackRecipes;

import BackRecipes.enums.Vegetarian;
import BackRecipes.model.Recipe;
import BackRecipes.model.User;
import BackRecipes.repository.UserRepository;
import BackRecipes.service.impl.RecipeService;
import BackRecipes.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import BackRecipes.repository.RecipeRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RecipeService recipeService;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setUsername("John");
        user1.setEmail("john@example.com");
        user1.setPassword("123");
        userService.saveUser(user1);

        User user2 = new User();
        user2.setUsername("Jane");
        user2.setEmail("jane@example.com");
        user2.setPassword("123");
        userService.saveUser(user2);

        User user3 = new User();
        user3.setUsername("Robert");
        user3.setEmail("robert@example.com");
        user3.setPassword("123");
        userService.saveUser(user3);

        Recipe spanishOmelette = new Recipe();
        spanishOmelette.setName("Spanish Omelette");
        spanishOmelette.setIngredients("Potatoes, Eggs, Onion, Olive Oil, Salt");
        spanishOmelette.setInstructions("Peel and slice the potatoes. Fry in olive oil until golden. Beat the eggs and mix with the potatoes. Cook in a skillet until set.");
        spanishOmelette.setImage("https://comedelahuerta.com/wp-content/uploads/2020/10/Tortilla-de-Patata-2048x1365.jpg");
        spanishOmelette.setVegetarian(Vegetarian.VEGETARIAN);
        spanishOmelette.setMinutes(30);
        spanishOmelette.setServings(4);
        spanishOmelette.setNumIngredients(5);
        spanishOmelette.setMadeBy(user1);
        recipeService.save(spanishOmelette);

        Recipe pastaWithPesto = new Recipe();
        pastaWithPesto.setName("Pasta with Pesto");
        pastaWithPesto.setIngredients("Pasta, Basil, Pine Nuts, Parmesan Cheese, Olive Oil");
        pastaWithPesto.setInstructions("Cook the pasta. Blend basil, pine nuts, cheese, and oil in a food processor. Combine with the pasta and serve.");
        pastaWithPesto.setImage("https://www.lavanguardia.com/files/og_thumbnail/uploads/2020/05/29/5ed11fb61d750.jpeg");
        pastaWithPesto.setVegetarian(Vegetarian.VEGETARIAN);
        pastaWithPesto.setMinutes(20);
        pastaWithPesto.setServings(4);
        pastaWithPesto.setNumIngredients(5);
        pastaWithPesto.setMadeBy(user2);
        recipeService.save(pastaWithPesto);

        Recipe lentilsWithChorizo = new Recipe();
        lentilsWithChorizo.setName("Lentils with Chorizo");
        lentilsWithChorizo.setIngredients("Lentils, Chorizo, Onion, Carrot, Broth");
        lentilsWithChorizo.setInstructions("Cook lentils with chorizo, onion, and carrot in broth until tender.");
        lentilsWithChorizo.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSO43W338Amk7s23LOcXlgqZ7JkvurSI4BsRA&s");
        lentilsWithChorizo.setVegetarian(Vegetarian.NO_VEGETARIAN);
        lentilsWithChorizo.setMinutes(45);
        lentilsWithChorizo.setServings(4);
        lentilsWithChorizo.setNumIngredients(5);
        lentilsWithChorizo.setMadeBy(user3);
        recipeService.save(lentilsWithChorizo);

        Recipe gazpacho = new Recipe();
        gazpacho.setName("Gazpacho");
        gazpacho.setIngredients("Tomatoes, Cucumbers, Bell Peppers, Olive Oil, Vinegar");
        gazpacho.setInstructions("Blend all ingredients until smooth. Chill before serving.");
        gazpacho.setImage("https://i.blogs.es/e64620/gazpacho/450_1000.jpg");
        gazpacho.setVegetarian(Vegetarian.VEGETARIAN);
        gazpacho.setMinutes(15);
        gazpacho.setServings(4);
        gazpacho.setNumIngredients(5);
        gazpacho.setMadeBy(user1);
        recipeService.save(gazpacho);

        Recipe zucchiniCreamSoup = new Recipe();
        zucchiniCreamSoup.setName("Zucchini Cream soup");
        zucchiniCreamSoup.setIngredients("Zucchini, Onion, Potato, Vegetable Broth, Cream");
        zucchiniCreamSoup.setInstructions("Sauté onions and zucchini. Add potatoes and broth, cook until tender. Blend and stir in cream.");
        zucchiniCreamSoup.setImage("https://www.vvsupremo.com/wp-content/uploads/2015/11/900X570_Zucchini-Cream-Soup.jpg");
        zucchiniCreamSoup.setVegetarian(Vegetarian.VEGETARIAN);
        zucchiniCreamSoup.setMinutes(30);
        zucchiniCreamSoup.setServings(4);
        zucchiniCreamSoup.setNumIngredients(5);
        zucchiniCreamSoup.setMadeBy(user2);
        recipeService.save(zucchiniCreamSoup);

        Recipe ratatouille = new Recipe();
        ratatouille.setName("Ratatouille");
        ratatouille.setIngredients("Zucchini, Bell Peppers, Tomatoes, Onion, Olive Oil");
        ratatouille.setInstructions("Sauté chopped vegetables in olive oil until tender. Serve warm, optionally with a fried egg on top.");
        ratatouille.setImage("https://comedelahuerta.com/wp-content/uploads/2020/09/iStock-1180869403.jpg");
        ratatouille.setVegetarian(Vegetarian.VEGETARIAN);
        ratatouille.setMinutes(30);
        ratatouille.setServings(4);
        ratatouille.setNumIngredients(5);
        ratatouille.setMadeBy(user1);
        recipeService.save(ratatouille);

        Recipe caesarSalad = new Recipe();
        caesarSalad.setName("Caesar Salad");
        caesarSalad.setIngredients("Romaine Lettuce, Croutons, Parmesan Cheese, Caesar Dressing, Anchovies");
        caesarSalad.setInstructions("Toss romaine with croutons, cheese, dressing, and anchovies. Serve immediately.");
        caesarSalad.setImage("https://s23209.pcdn.co/wp-content/uploads/2023/01/220905_DD_Chx-Caesar-Salad_051.jpg");
        caesarSalad.setVegetarian(Vegetarian.NO_VEGETARIAN);
        caesarSalad.setMinutes(15);
        caesarSalad.setServings(4);
        caesarSalad.setNumIngredients(5);
        caesarSalad.setMadeBy(user2);
        recipeService.save(caesarSalad);

        Recipe redPepperCreamSoup = new Recipe();
        redPepperCreamSoup.setName("Red Pepper Cream Soup");
        redPepperCreamSoup.setIngredients("Red Peppers, Onion, Garlic, Cream, Vegetable Broth");
        redPepperCreamSoup.setInstructions("Sauté onions and garlic, add roasted peppers and broth, blend until smooth. Stir in cream.");
        redPepperCreamSoup.setImage("https://playswellwithbutter.com/wp-content/uploads/2023/03/Creamy-Roasted-Red-Pepper-Soup-9.jpg");
        redPepperCreamSoup.setVegetarian(Vegetarian.VEGETARIAN);
        redPepperCreamSoup.setMinutes(30);
        redPepperCreamSoup.setServings(4);
        redPepperCreamSoup.setNumIngredients(5);
        redPepperCreamSoup.setMadeBy(user2);
        recipeService.save(redPepperCreamSoup);

        Recipe brokenEggs = new Recipe();
        brokenEggs.setName("Broken Eggs");
        brokenEggs.setIngredients("Eggs, Potatoes, Jamón Ibérico, Olive Oil, Salt");
        brokenEggs.setInstructions("Fry potatoes until crispy, top with fried eggs and jamón. Serve immediately.");
        brokenEggs.setImage("https://i0.wp.com/spainonafork.wpengine.com/wp-content/uploads/2017/04/huevos-22.png?resize=531%2C800&ssl=1");
        brokenEggs.setVegetarian(Vegetarian.NO_VEGETARIAN);
        brokenEggs.setMinutes(25);
        brokenEggs.setServings(2);
        brokenEggs.setNumIngredients(5);
        brokenEggs.setMadeBy(user3);
        recipeService.save(brokenEggs);

        Recipe grilledVegetables = new Recipe();
        grilledVegetables.setName("Grilled Vegetables");
        grilledVegetables.setIngredients("Zucchini, Bell Peppers, Eggplant, Olive Oil, Garlic");
        grilledVegetables.setInstructions("Slice vegetables, toss with olive oil and garlic, and grill until tender.");
        grilledVegetables.setImage("https://s23209.pcdn.co/wp-content/uploads/2020/08/Easy-Grilled-VegetablesIMG_0768.jpg");
        grilledVegetables.setVegetarian(Vegetarian.VEGETARIAN);
        grilledVegetables.setMinutes(20);
        grilledVegetables.setServings(4);
        grilledVegetables.setNumIngredients(5);
        grilledVegetables.setMadeBy(user2);
        recipeService.save(grilledVegetables);

        Recipe seafoodPaella = new Recipe();
        seafoodPaella.setName("Seafood Paella");
        seafoodPaella.setIngredients("Rice, Shrimp, Mussels, Calamari, Saffron");
        seafoodPaella.setInstructions("Sauté seafood, add rice and broth, cook until rice absorbs the liquid.");
        seafoodPaella.setImage("https://silveroak.com/wp-content/uploads/2020/02/Recipe-Seafood-Paella.jpg");
        seafoodPaella.setVegetarian(Vegetarian.NO_VEGETARIAN);
        seafoodPaella.setMinutes(50);
        seafoodPaella.setServings(4);
        seafoodPaella.setNumIngredients(5);
        seafoodPaella.setMadeBy(user2);
        recipeService.save(seafoodPaella);

        Recipe chorizoAndPotatoHash = new Recipe();
        chorizoAndPotatoHash.setName("Chorizo and Potato Hash");
        chorizoAndPotatoHash.setIngredients("Chorizo, Potatoes, Onion, Bell Peppers, Eggs");
        chorizoAndPotatoHash.setInstructions("Cook chorizo and vegetables, add potatoes until crispy. Top with fried eggs.");
        chorizoAndPotatoHash.setImage("https://cdn.donnahaycdn.com.au/images/content-images/smoked_chorizo_maple_and_sweet_potato_hash.jpg");
        chorizoAndPotatoHash.setVegetarian(Vegetarian.NO_VEGETARIAN);
        chorizoAndPotatoHash.setMinutes(30);
        chorizoAndPotatoHash.setServings(4);
        chorizoAndPotatoHash.setNumIngredients(5);
        chorizoAndPotatoHash.setMadeBy(user3);
        recipeService.save(chorizoAndPotatoHash);

        Recipe classicTiramisu = new Recipe();
        classicTiramisu.setName("Classic Tiramisu");
        classicTiramisu.setIngredients("Mascarpone Cheese, Coffee, Ladyfingers, Cocoa Powder, Sugar");
        classicTiramisu.setInstructions("Layer soaked ladyfingers with mascarpone mixture. Chill and dust with cocoa before serving.");
        classicTiramisu.setImage("https://www.alsothecrumbsplease.com/wp-content/uploads/2020/09/Authentic-Tiramisu-Recipe-17-1.jpg");
        classicTiramisu.setVegetarian(Vegetarian.VEGETARIAN);
        classicTiramisu.setMinutes(20);
        classicTiramisu.setServings(6);
        classicTiramisu.setNumIngredients(5);
        classicTiramisu.setMadeBy(user1);
        recipeService.save(classicTiramisu);

        Recipe bakedStuffedPeppers = new Recipe();
        bakedStuffedPeppers.setName("Baked Stuffed Peppers");
        bakedStuffedPeppers.setIngredients("Bell Peppers, Rice, Ground Meat, Tomato Sauce, Cheese");
        bakedStuffedPeppers.setInstructions("Stuff peppers with rice, meat, and sauce. Bake until peppers are tender.");
        bakedStuffedPeppers.setImage("https://santokuknives.co.uk/cdn/shop/articles/Untitled_design_13-471062.jpg?v=1715727234&width=1920");
        bakedStuffedPeppers.setVegetarian(Vegetarian.NO_VEGETARIAN);
        bakedStuffedPeppers.setMinutes(45);
        bakedStuffedPeppers.setServings(4);
        bakedStuffedPeppers.setNumIngredients(5);
        bakedStuffedPeppers.setMadeBy(user2);
        recipeService.save(bakedStuffedPeppers);

        Recipe orangeFlan = new Recipe();
        orangeFlan.setName("Orange Flan");
        orangeFlan.setIngredients("Eggs, Milk, Sugar, Orange Zest, Vanilla");
        orangeFlan.setInstructions("Blend ingredients, pour into a caramel-coated pan, and bake in a water bath.");
        orangeFlan.setImage("https://marisolcooks.com/wp-content/uploads/2021/05/IMG_3870-1-scaled.jpg");
        orangeFlan.setVegetarian(Vegetarian.VEGETARIAN);
        orangeFlan.setMinutes(60);
        orangeFlan.setServings(6);
        orangeFlan.setNumIngredients(5);
        orangeFlan.setMadeBy(user3);
        recipeService.save(orangeFlan);

        Recipe fruitSalad = new Recipe();
        fruitSalad.setName("Fruit Salad");
        fruitSalad.setIngredients("Strawberries, Blueberries, Kiwi, Mango, Mint");
        fruitSalad.setInstructions("Chop fruits, toss with mint, and serve chilled.");
        fruitSalad.setImage("https://images.themodernproper.com/billowy-turkey/production/posts/2022/FruitSalad_Shot4_20.jpg?w=960&h=960&q=82&fm=jpg&fit=crop&dm=1654019861&s=abb0af9baa0039bf1e91942aa34af247");
        fruitSalad.setVegetarian(Vegetarian.VEGETARIAN);
        fruitSalad.setMinutes(15);
        fruitSalad.setServings(4);
        fruitSalad.setNumIngredients(5);
        fruitSalad.setMadeBy(user1);
        recipeService.save(fruitSalad);

        Recipe creamyMushroomRisotto = new Recipe();
        creamyMushroomRisotto.setName("Creamy Mushroom Risotto");
        creamyMushroomRisotto.setIngredients("Arborio Rice, Mushrooms, Onion, Broth, Parmesan Cheese");
        creamyMushroomRisotto.setInstructions("Sauté onions and mushrooms, add rice, and gradually add broth while stirring until creamy. Stir in cheese before serving.");
        creamyMushroomRisotto.setImage("https://www.crazyvegankitchen.com/wp-content/uploads/2023/02/mushroom-risotto-recipe.jpeg");
        creamyMushroomRisotto.setVegetarian(Vegetarian.VEGETARIAN);
        creamyMushroomRisotto.setMinutes(40);
        creamyMushroomRisotto.setServings(4);
        creamyMushroomRisotto.setNumIngredients(5);
        creamyMushroomRisotto.setMadeBy(user3);
        recipeService.save(creamyMushroomRisotto);

        Recipe capreseSalad = new Recipe();
        capreseSalad.setName("Caprese Salad");
        capreseSalad.setIngredients("Tomatoes, Mozzarella Cheese, Basil, Olive Oil, Balsamic Vinegar");
        capreseSalad.setInstructions("Layer sliced tomatoes and mozzarella, sprinkle with basil, drizzle with oil and vinegar. Serve fresh.");
        capreseSalad.setImage("https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2019/07/Caprese-Salad-main-1.jpg");
        capreseSalad.setVegetarian(Vegetarian.VEGETARIAN);
        capreseSalad.setMinutes(10);
        capreseSalad.setServings(4);
        capreseSalad.setNumIngredients(5);
        capreseSalad.setMadeBy(user1);
        recipeService.save(capreseSalad);

        Recipe eggplantParmesan = new Recipe();
        eggplantParmesan.setName("Eggplant Parmesan");
        eggplantParmesan.setIngredients("Eggplant, Marinara Sauce, Mozzarella Cheese, Parmesan Cheese, Basil");
        eggplantParmesan.setInstructions("Layer breaded and fried eggplant slices with marinara and cheese, bake until golden and bubbly.");
        eggplantParmesan.setImage("https://i0.wp.com/smittenkitchen.com/wp-content/uploads//2019/09/stuffed-eggplant-parmesan.jpg?fit=1200%2C800&ssl=1");
        eggplantParmesan.setVegetarian(Vegetarian.VEGETARIAN);
        eggplantParmesan.setMinutes(60);
        eggplantParmesan.setServings(4);
        eggplantParmesan.setNumIngredients(5);
        eggplantParmesan.setMadeBy(user2);
        recipeService.save(eggplantParmesan);

        Recipe coconutRice = new Recipe();
        coconutRice.setName("Coconut Rice");
        coconutRice.setIngredients("Rice, Coconut Milk, Sugar, Salt, Water");
        coconutRice.setInstructions("Cook rice with coconut milk, sugar, and salt until tender. Serve as a side dish.");
        coconutRice.setImage("https://www.maggi.in/sites/default/files/srh_recipes/1917c8eb89672185ec3920ed2c1eaf60.jpg");
        coconutRice.setVegetarian(Vegetarian.VEGETARIAN);
        coconutRice.setMinutes(30);
        coconutRice.setServings(4);
        coconutRice.setNumIngredients(5);
        coconutRice.setMadeBy(user3);
        recipeService.save(coconutRice);

        Recipe roastedBeetSalad = new Recipe();
        roastedBeetSalad.setName("Roasted Beet Salad");
        roastedBeetSalad.setIngredients("Beets, Goat Cheese, Walnuts, Arugula, Balsamic Dressing");
        roastedBeetSalad.setInstructions("Roast beets until tender, slice and toss with arugula, goat cheese, walnuts, and dressing.");
        roastedBeetSalad.setImage("https://thecozyapron.com/wp-content/uploads/2012/02/roasted-beet-salad_thecozyapron_1.jpg");
        roastedBeetSalad.setVegetarian(Vegetarian.VEGETARIAN);
        roastedBeetSalad.setMinutes(45);
        roastedBeetSalad.setServings(4);
        roastedBeetSalad.setNumIngredients(5);
        roastedBeetSalad.setMadeBy(user1);
        recipeService.save(roastedBeetSalad);

        Recipe butternutSquashSoup = new Recipe();
        butternutSquashSoup.setName("Butternut Squash Soup");
        butternutSquashSoup.setIngredients("Butternut Squash, Onion, Vegetable Broth, Cream, Nutmeg");
        butternutSquashSoup.setInstructions("Sauté onions, add squash and broth, cook until tender, blend, and stir in cream and nutmeg.");
        butternutSquashSoup.setImage("https://minimalistbaker.com/wp-content/uploads/2015/09/AMAZING-30-Minute-Curried-Butternut-Squash-Soup-Creamy-flavorful-and-perfect-for-fall-vegan-glutenfree-soup-squash-fall-recipe-healthy.jpg");
        butternutSquashSoup.setVegetarian(Vegetarian.VEGETARIAN);
        butternutSquashSoup.setMinutes(40);
        butternutSquashSoup.setServings(4);
        butternutSquashSoup.setNumIngredients(5);
        butternutSquashSoup.setMadeBy(user2);
        recipeService.save(butternutSquashSoup);

        Recipe quinoaSalad = new Recipe();
        quinoaSalad.setName("Quinoa Salad");
        quinoaSalad.setIngredients("Quinoa, Cucumber, Tomatoes, Feta Cheese, Lemon Dressing");
        quinoaSalad.setInstructions("Cook quinoa, cool, and toss with diced vegetables, feta, and dressing.");
        quinoaSalad.setImage("https://www.themediterraneandish.com/wp-content/uploads/2024/01/TMD-Quinoa-Salad-15.jpg");
        quinoaSalad.setVegetarian(Vegetarian.VEGETARIAN);
        quinoaSalad.setMinutes(20);
        quinoaSalad.setServings(4);
        quinoaSalad.setNumIngredients(5);
        quinoaSalad.setMadeBy(user3);
        recipeService.save(quinoaSalad);

        Recipe chickenFajitas = new Recipe();
        chickenFajitas.setName("Chicken Fajitas");
        chickenFajitas.setIngredients("Chicken, Bell Peppers, Onion, Tortillas, Fajita Seasoning");
        chickenFajitas.setInstructions("Sauté chicken with peppers and onions, serve with warm tortillas and toppings.");
        chickenFajitas.setImage("https://thefoodcharlatan.com/wp-content/uploads/2024/02/Chicken-Fajitas-Recipe-19.jpg");
        chickenFajitas.setVegetarian(Vegetarian.NO_VEGETARIAN);
        chickenFajitas.setMinutes(30);
        chickenFajitas.setServings(4);
        chickenFajitas.setNumIngredients(5);
        chickenFajitas.setMadeBy(user1);
        recipeService.save(chickenFajitas);

        Recipe vegetableStirFry = new Recipe();
        vegetableStirFry.setName("Vegetable Stir-Fry");
        vegetableStirFry.setIngredients("Broccoli, Carrots, Bell Peppers, Soy Sauce, Garlic");
        vegetableStirFry.setInstructions("Stir-fry vegetables in a hot pan with oil, garlic, and soy sauce until tender.");
        vegetableStirFry.setImage("https://images.themodernproper.com/billowy-turkey/production/posts/VegetableStirFry_9.jpg?w=1200&h=1200&q=60&fm=jpg&fit=crop&dm=1703377301&s=3484d660c4b404c6d23b0c3ec7ac66eb");
        vegetableStirFry.setVegetarian(Vegetarian.VEGETARIAN);
        vegetableStirFry.setMinutes(20);
        vegetableStirFry.setServings(4);
        vegetableStirFry.setNumIngredients(5);
        vegetableStirFry.setMadeBy(user2);
        recipeService.save(vegetableStirFry);

        Recipe chickenCurry = new Recipe();
        chickenCurry.setName("Chicken Curry");
        chickenCurry.setIngredients("Chicken, Curry Powder, Coconut Milk, Onion, Garlic");
        chickenCurry.setInstructions("Sauté onions and garlic, add chicken and curry powder, cook until browned. Pour in coconut milk and simmer until cooked through.");
        chickenCurry.setImage("https://www.kitchensanctuary.com/wp-content/uploads/2020/08/Easy-Chicken-Curry-square-FS-117.jpg");
        chickenCurry.setVegetarian(Vegetarian.NO_VEGETARIAN);
        chickenCurry.setMinutes(45);
        chickenCurry.setServings(4);
        chickenCurry.setNumIngredients(5);
        chickenCurry.setMadeBy(user3);
        recipeService.save(chickenCurry);

        Recipe beefTacos = new Recipe();
        beefTacos.setName("Beef Tacos");
        beefTacos.setIngredients("Ground Beef, Taco Shells, Lettuce, Tomato, Cheese");
        beefTacos.setInstructions("Cook ground beef with taco seasoning. Fill taco shells with beef and top with lettuce, tomato, and cheese.");
        beefTacos.setImage("https://joyfoodsunshine.com/wp-content/uploads/2022/04/mexian-ground-beef-tacos-recipe-9.jpg");
        beefTacos.setVegetarian(Vegetarian.NO_VEGETARIAN);
        beefTacos.setMinutes(30);
        beefTacos.setServings(4);
        beefTacos.setNumIngredients(5);
        beefTacos.setMadeBy(user1);
        recipeService.save(beefTacos);

        Recipe salmonFillet = new Recipe();
        salmonFillet.setName("Grilled Salmon Fillet");
        salmonFillet.setIngredients("Salmon, Olive Oil, Lemon, Garlic, Herbs");
        salmonFillet.setInstructions("Marinate salmon with olive oil, lemon juice, garlic, and herbs. Grill until cooked through.");
        salmonFillet.setImage("https://www.cookingclassy.com/wp-content/uploads/2017/02/skillet-seared-salmon-2.jpg");
        salmonFillet.setVegetarian(Vegetarian.NO_VEGETARIAN);
        salmonFillet.setMinutes(20);
        salmonFillet.setServings(4);
        salmonFillet.setNumIngredients(5);
        salmonFillet.setMadeBy(user2);
        recipeService.save(salmonFillet);

        Recipe shrimpScampi = new Recipe();
        shrimpScampi.setName("Shrimp Scampi");
        shrimpScampi.setIngredients("Shrimp, Garlic, Butter, Lemon, Parsley");
        shrimpScampi.setInstructions("Sauté garlic in butter, add shrimp and cook until pink. Stir in lemon juice and parsley before serving.");
        shrimpScampi.setImage("https://assets.bonappetit.com/photos/58a4e12a9fda6d7fbc740e91/1:1/w_3333,h_3333,c_limit/shrimp-scampi.jpg");
        shrimpScampi.setVegetarian(Vegetarian.NO_VEGETARIAN);
        shrimpScampi.setMinutes(25);
        shrimpScampi.setServings(4);
        shrimpScampi.setNumIngredients(5);
        shrimpScampi.setMadeBy(user1);
        recipeService.save(shrimpScampi);

        Recipe teriyakiChicken = new Recipe();
        teriyakiChicken.setName("Teriyaki Chicken");
        teriyakiChicken.setIngredients("Chicken, Soy Sauce, Honey, Ginger, Garlic");
        teriyakiChicken.setInstructions("Marinate chicken in soy sauce, honey, ginger, and garlic. Cook in a pan until golden and serve.");
        teriyakiChicken.setImage("https://cdn.apartmenttherapy.info/image/upload/f_jpg,q_auto:eco,c_fill,g_auto,w_1500,ar_1:1/k%2FPhoto%2FRecipes%2F2024-05-chicken-teriyaki-190%2Fchicken-teriyaki-190-171-horizontal");
        teriyakiChicken.setVegetarian(Vegetarian.NO_VEGETARIAN);
        teriyakiChicken.setMinutes(30);
        teriyakiChicken.setServings(4);
        teriyakiChicken.setNumIngredients(5);
        teriyakiChicken.setMadeBy(user2);
        recipeService.save(teriyakiChicken);
    }


}
