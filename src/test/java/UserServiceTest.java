import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import userapi.model.User;
import userapi.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test Klasse zum überprüfen der basis Funktionen der {@link UserService}.
 *
 * @author MDzan
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    private final String testUserName = "Max Mustermann";
    private final String testUserMail = "max@emailadresse.com";

    @Test
    void createUser() {
        User user = new User();
        user.setName(testUserName);
        user.setEmail(testUserMail);

        User savedUser = userService.createUser(user);

        assertNotNull(savedUser.getId());
        assertEquals(testUserName, savedUser.getName());
        assertEquals(testUserMail, savedUser.getEmail());
    }

    @Test
    void getUserById() {
        User user = new User();

        user.setName(testUserName);
        user.setEmail(testUserMail);
        User savedUser = userService.createUser(user);

        User foundUser = userService.getUserById(savedUser.getId());

        assertEquals(testUserName, foundUser.getName());
        assertEquals(testUserMail, savedUser.getEmail());
    }
}