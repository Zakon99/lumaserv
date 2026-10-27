package userapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import userapi.dto.CreateUserRequest;
import userapi.dto.UserResponse;
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
    public UserResponse getUserById(final Long id) {
        return userRepository.findById(id)
                .map(UserResponse::from)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Methode zum anlegen eines neuen Users.
     * @param request Request zum anlegen eines Users
     * @return der neu angelegte User
     */
    @Transactional
    public UserResponse createUser(final CreateUserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailExistsException(request.email());
        }
        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        return UserResponse.from(userRepository.save(user));
    }
}
