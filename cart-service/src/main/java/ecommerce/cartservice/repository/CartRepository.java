package ecommerce.cartservice.repository;

import ecommerce.cartservice.model.CartEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, String>
{
    @Query("SELECT u From CartEntity u WHERE u.userUsername = :username")
    Optional<CartEntity> findCartEntityByUsername  (@Param("username") String username);
    @Query("SELECT u From CartEntity u WHERE u.userUsername = :username")
    CartEntity findCartEntityByUsername1  (@Param("username") String username);
}
