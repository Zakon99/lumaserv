package userapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception, falls der abgefragte User nicht in der Datenbank exsistiert.
 *
 * @author MDzan
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(final Long id){
        super("User konnte nicht gefunden werden. ID: "+ id);
    }
}
