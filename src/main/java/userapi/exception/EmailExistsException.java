package userapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception, falls die Email adresse zum anlegen eines Users bereits in der Datenbank existiert.
 *
 * @author MDzan
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class EmailExistsException extends RuntimeException {

    public EmailExistsException(final String email){
        super("User konnte nicht angelegt werden. Email adresse wird bereits verwendet. Email: "+ email);
    }
}
