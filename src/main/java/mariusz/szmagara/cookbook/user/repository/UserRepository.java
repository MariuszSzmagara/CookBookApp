package mariusz.szmagara.cookbook.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import mariusz.szmagara.cookbook.user.dto.AccountDetailsToModifyFormDto;
import mariusz.szmagara.cookbook.user.model.User;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    void deleteUserById(Long id);

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByPasswordResetKey(String passwordResetKey);

    @Transactional
    @Modifying
    @Query("UPDATE User user SET user.firstName = :#{#userAccountDetailsToModify.firstName}, " +
            "user.lastName = :#{#userAccountDetailsToModify.lastName}, " +
            "user.password = :#{#userAccountDetailsToModify.password} WHERE user.id = :#{#userAccountDetailsToModify.id}")
    void updateUserAccountDetails(@Param("userAccountDetailsToModify") AccountDetailsToModifyFormDto userAccountDetailsToModify);

}
