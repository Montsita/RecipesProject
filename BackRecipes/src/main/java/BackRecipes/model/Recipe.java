package BackRecipes.model;

import BackRecipes.enums.Vegetarian;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;

    private String name;
    private String ingredients;
    private String instructions;
    private String image;
    @Enumerated(EnumType.STRING)
    private Vegetarian vegetarian;
    private int minutes;
    private int servings;
    private int numIngredients;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User madeBy;
}
