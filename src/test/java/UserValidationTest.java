import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import userapi.model.User;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test Klasse zum überprüfen der Validierungsfunktionen von {@link User}.
 *
 * @author MDzan
 */
class UserValidationTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private final String testUserName = "Max Mustermann";
    private final String testUserMail = "max@emailadresse.com";

    @Test
    void emailIsNull_isInvalid() {
        User user = new User();
        user.setName(testUserName);
        user.setEmail(null);

        assertFalse(validator.validate(user).isEmpty());
    }

    @Test
    void nameIsNull_isInvalid() {
        User user = new User();
        user.setName(null);
        user.setEmail(testUserMail);

        assertFalse(validator.validate(user).isEmpty());
    }
}