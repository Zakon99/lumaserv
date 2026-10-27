import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import userapi.dto.CreateUserRequest;
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
    void emailIsNull() {
        CreateUserRequest request = new CreateUserRequest(testUserName, null);
        assertFalse(validator.validate(request).isEmpty());
    }

    @Test
    void userNameIsNull() {
        CreateUserRequest request = new CreateUserRequest(null, testUserMail);
        assertFalse(validator.validate(request).isEmpty());
    }
}