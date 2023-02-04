package mariusz.szmagara.cookbook.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import mariusz.szmagara.cookbook.ingredient.model.Ingredient;
import mariusz.szmagara.cookbook.recipe.model.Category;
import mariusz.szmagara.cookbook.recipe.model.Recipe;
import mariusz.szmagara.cookbook.recipe.service.RecipeService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        List<Recipe> allRecipesList = recipeService.findAll();
        model.addAttribute("allRecipesList", allRecipesList);
        return "home";
    }

    @GetMapping("/newRecipe")
    public String getNewRecipeForm(Model model) {
        Recipe newRecipe = new Recipe();
//        List<Ingredient> ingredients = new ArrayList<>();
//        newRecipe.setIngredients(ingredients);
        newRecipe.initializeListOfIngredients();
        newRecipe.addFirstEmptyIngredientToRecipe(new Ingredient());
//        newRecipe.getIngredients().add(new Ingredient());
        model.addAttribute("newRecipe", newRecipe);
        return "newRecipeForm";
    }

//    @PostMapping(value="/addNewRecipe", params="addIngredient")
//    public String addIngredient(Recipe newRecipe, Model model) {
//        if (newRecipe != null) {
//            if (newRecipe.getIngredients() == null) {
//                List<Ingredient> ingredients = new ArrayList<>();
//                newRecipe.setIngredients(ingredients);
//                newRecipe.addIngredient(new Ingredient());
//            } else {
//                newRecipe.addIngredient(new Ingredient());
////                newRecipe.getIngredients().add(new Ingredient());
//            }
//        }
//        model.addAttribute("newRecipe", newRecipe);
//        return "newRecipeForm";
//    }

    @PostMapping(value="/addNewRecipe", params="addIngredient")
    public String addIngredient(final Recipe newRecipe, Model model) {
        if (newRecipe != null) {
            newRecipe.addIngredient(new Ingredient());
//            newRecipe.getIngredients().add(new Ingredient());
        }
        model.addAttribute("newRecipe", newRecipe);
        return "newRecipeForm";
    }

    @PostMapping(value="/addNewRecipe", params="removeIngredient")
    public String removeIngredient(final Recipe newRecipe, Model model, final HttpServletRequest req) {
        final int rowId = Integer.parseInt(req.getParameter("removeIngredient"));
        newRecipe.getIngredients().remove(rowId);
        model.addAttribute("newRecipe", newRecipe);
        return "newRecipeForm";
    }

    @PostMapping(value = "/addNewRecipe", params = {"addRecipe"})
    public String addNewRecipe(Recipe newRecipe) {
        for (Ingredient ingredient : newRecipe.getIngredients()) {
            ingredient.setRecipe(newRecipe);
        }
        recipeService.addNewRecipe(newRecipe);
        return "redirect:/";
    }

    @GetMapping("/recipe/{id}/display")
    public String showRecipe(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeById = recipeService.findById(id);
        if (recipeById.isPresent()) {
            Recipe recipeToDisplay = recipeById.get();
            model.addAttribute("recipeToDisplay", recipeToDisplay);
            return "recipe";
        } else {
            return "error";
        }
    }

    @GetMapping("/recipe/{id}/modify")
    public String modifyRecipe(@PathVariable Long id, Model model) {
        Optional<Recipe> recipeById = recipeService.findById(id);
        if (recipeById.isPresent()) {
            Recipe recipeToModify = recipeById.get();
            model.addAttribute("recipeToModify", recipeToModify);
            return "modifyRecipeForm";
        } else {
            return "error";
        }
    }

    @PostMapping("/recipe/{id}/update")
    public String updateWholeRecipeById(Recipe recipeToUpdate) {
        recipeService.update(recipeToUpdate);
        return "redirect:/";
    }

    @PostMapping("/recipe/{id}/updateLikesCounter/like")
    public String updateRecipeLikesCounterById(@PathVariable Long id) {
        recipeService.updateRecipeLikesCounterById(id, 1);
        return "redirect:/";
    }

    @PostMapping("/recipe/{id}/delete")
    public String deleteRecipeById(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
        return "redirect:/";
    }

    @GetMapping("/recipes/{category}")
    public String getRecipesListByCategory(@PathVariable Category category, Model model) {
        List<Recipe> recipesListByCategory = recipeService.findByCategory(category);
        model.addAttribute("recipesListByCategory", recipesListByCategory);
        model.addAttribute("categoryName", category.name());
        return "category";
    }

    @GetMapping("/recipes/orderByLikes")
    public String getAllRecipesListOrderedByLikes(Model model) {
        List<Recipe> allRecipesListOrderByLikesCounter = recipeService.findAllByOrderByLikesCounterDesc();
        model.addAttribute("allRecipesListOrderByLikesCounter", allRecipesListOrderByLikesCounter);
        return "allRecipesListOrderByLikesCounter";
    }
}
