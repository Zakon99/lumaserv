package userapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Record für die RequestStruktur eines CreateUserRequests.
 * @param name
 * @param email
 *
 * @author MDzan
 */
public record CreateUserRequest (
    @NotBlank String name,
    @NotBlank @Email String email
){

}
