package ecommerce.userservice.Repository;

import ecommerce.userservice.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>


{

    Optional<UserEntity>  findByUsername(String username);

    Optional<UserEntity>  findById(String id);
    boolean existsByUsername(String username);
    boolean existsById(String id);
    void deleteById(String id);
}
