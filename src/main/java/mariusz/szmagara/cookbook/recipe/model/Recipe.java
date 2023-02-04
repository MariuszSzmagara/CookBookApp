package mariusz.szmagara.cookbook.recipe.model;

import mariusz.szmagara.cookbook.ingredient.model.Ingredient;
import mariusz.szmagara.cookbook.preparationtime.model.PreparationTime;
import mariusz.szmagara.cookbook.preparationtime.converter.PreparationTimeConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 5_000)
    private String preparationInstructions;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int serves;
    private int likesCounter;
    @Convert(converter = PreparationTimeConverter.class)
    private PreparationTime preparationTime;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    public Recipe() {
    }

    public Recipe(String title, Category category, int serves, int likesCounter, PreparationTime preparationTime,
                  List<Ingredient> ingredients, String preparationInstructions) {
        this.title = title;
        this.category = category;
        this.serves = serves;
        this.likesCounter = likesCounter;
        this.preparationTime = preparationTime;
        this.ingredients = ingredients;
        this.preparationInstructions = preparationInstructions;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
        ingredient.setRecipe(null);
    }

    public void initializeListOfIngredients() {
        setIngredients(new ArrayList<>());
    }

    public void addFirstEmptyIngredientToRecipe(Ingredient ingredient) {
        addIngredient(ingredient);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getServes() {
        return serves;
    }

    public void setServes(int serves) {
        this.serves = serves;
    }

    public int getLikesCounter() {
        return likesCounter;
    }

    public void setLikesCounter(int likesCounter) {
        this.likesCounter = likesCounter;
    }

    public PreparationTime getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(PreparationTime preparationTime) {
        this.preparationTime = preparationTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparationInstructions() {
        return preparationInstructions;
    }

    public void setPreparationInstructions(String preparationInstructions) {
        this.preparationInstructions = preparationInstructions;
    }
}
