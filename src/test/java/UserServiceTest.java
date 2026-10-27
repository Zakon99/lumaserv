import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import userapi.UserApplication;
import userapi.dto.CreateUserRequest;
import userapi.dto.UserResponse;
import userapi.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test Klasse zum überprüfen der basis Funktionen der {@link UserService}.
 *
 * @author MDzan
 */
@SpringBootTest(classes = UserApplication.class)
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    private final String testUserName = "Max Mustermann";
    private final String testUserMail = "max@emailadresse.com";

    @Test
    void createUser() {
        UserResponse savedUser = userService.createUser(
                new CreateUserRequest(testUserName, testUserMail)
        );

        assertNotNull(savedUser.id());
        assertEquals(testUserName, savedUser.name());
    }

    @Test
    void getUserById() {
        UserResponse saved = userService.createUser(
                new CreateUserRequest(testUserName, testUserMail)
        );

        UserResponse foundUser = userService.getUserById(saved.id());

        assertEquals(testUserName, foundUser.name());
    }
}