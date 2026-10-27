package userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import userapi.model.User;

/**
 * User Repository
 *
 * @author MDzan
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Methode zum überprüfen, ob ein {@link User} basierend auf der E-Maile bereits existiert.
     * @param email
     * @return true = Email bereits vergeben
     */
    boolean existsByEmail(@Param("email") String email);
}
