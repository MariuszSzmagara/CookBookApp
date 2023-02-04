package mariusz.szmagara.cookbook.recipe.service;

import org.springframework.stereotype.Service;
import mariusz.szmagara.cookbook.recipe.model.Category;
import mariusz.szmagara.cookbook.recipe.model.Recipe;
import mariusz.szmagara.cookbook.recipe.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public void addNewRecipe(Recipe newRecipe) {
        recipeRepository.save(newRecipe);
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public void update(Recipe recipeToUpdate) {
        recipeRepository.save(recipeToUpdate);
    }

    public void updateRecipeLikesCounterById(Long id, int i) {
        recipeRepository.updateRecipeLikesCounterById(id, i);
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteRecipeById(id);
    }

    public List<Recipe> findByCategory(Category category) {
        return recipeRepository.findByCategory(category);
    }

    public List<Recipe> findAllByOrderByLikesCounterDesc() {
        return recipeRepository.findAllByOrderByLikesCounterDesc();
    }
}
