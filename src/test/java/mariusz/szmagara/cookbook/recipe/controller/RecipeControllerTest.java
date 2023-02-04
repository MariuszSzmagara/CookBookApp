package mariusz.szmagara.cookbook.recipe.controller;

import mariusz.szmagara.cookbook.recipe.service.RecipeService;
import mariusz.szmagara.cookbook.user.service.MyUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser
@WebMvcTest(controllers = RecipeController.class)
class RecipeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    RecipeService recipeService;
    @MockBean
    MyUserDetailsService myUserDetailsService;

    @Test
    public void shouldCreateMackMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    @WithMockUser
    public void newRecipeFormPageShouldHaveAnHtmlForm() throws Exception {
        mockMvc.perform(get("/newRecipe"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void postAddNewRecipeShouldWork() throws Exception {
        mockMvc.perform(post("/addNewRecipe"))
                .andExpect(redirectedUrl("/"));
    }

    @Test
    void getHome() {
    }

    @Test
    void getNewRecipeForm() {
    }

    @Test
    void addIngredient() {
    }

    @Test
    void removeIngredient() {
    }

    @Test
    void addNewRecipe() {
    }

    @Test
    void showRecipe() {
    }

    @Test
    void modifyRecipe() {
    }

    @Test
    void updateWholeRecipeById() {
    }

    @Test
    void updateRecipeLikesCounterById() {
    }

    @Test
    void deleteRecipeById() {
    }

    @Test
    void getRecipesListByCategory() {
    }

    @Test
    void getAllRecipesListOrderedByLikes() {
    }
}