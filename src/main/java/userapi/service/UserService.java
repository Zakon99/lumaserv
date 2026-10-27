package userapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import userapi.exception.EmailExistsException;
import userapi.exception.UserNotFoundException;
import userapi.model.User;
import userapi.repository.UserRepository;

/**
 * UserService
 *
 * @author MDzan
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Methode zum Abfragen eines Users basierend auf der ID.
     * @param id die id des Users
     * @return abgefragte User
     */
    @Transactional
    public User getUserById(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Methode zum anlegen eines neuen Users.
     * @param user der anzulegende User
     * @return der neu angelegte User
     */
    @Transactional
    public User createUser(final User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new EmailExistsException(user.getEmail());
        }
        return userRepository.save(user);
    }
}
