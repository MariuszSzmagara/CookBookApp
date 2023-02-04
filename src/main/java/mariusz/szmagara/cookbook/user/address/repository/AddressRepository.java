package mariusz.szmagara.cookbook.user.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import mariusz.szmagara.cookbook.user.address.model.Address;

import javax.transaction.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Address address SET address.user.id = :userId WHERE address.id = :id")
    void updateUserId(@Param("id") Long id, @Param("userId") Long userId);
}
