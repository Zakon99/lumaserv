package userapi.dto;

import userapi.model.User;

/**
 * Record für die RequestStruktur eines getUserRequests.
 * @param id
 * @param name
 * @param email
 */
public record UserResponse(Long id, String name, String email) {

    /**
     * Methode zum erstellen des ResponseBody basierend auf eines {@link User}.
     * @param user
     * @return UserResponseRecord
     */
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}