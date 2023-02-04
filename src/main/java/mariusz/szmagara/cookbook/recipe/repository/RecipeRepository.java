package mariusz.szmagara.cookbook.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import mariusz.szmagara.cookbook.recipe.model.Category;
import mariusz.szmagara.cookbook.recipe.model.Recipe;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByCategory(Category category);

    List<Recipe> findAllByOrderByLikesCounterDesc();

    @Transactional
    @Modifying
    @Query("UPDATE Recipe recipe SET recipe.likesCounter = recipe.likesCounter + :byHowMuch WHERE recipe.id = :id")
    void updateRecipeLikesCounterById(@Param("id") Long id, @Param("byHowMuch") int byHowMuch);

    @Transactional
    @Modifying
    void deleteRecipeById(Long id);

}
