package userapi.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import userapi.dto.CreateUserRequest;
import userapi.dto.UserResponse;
import userapi.service.UserService;

import java.net.URI;

/**
 * UserController
 *
 * @author MDzan
 */
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "User gefunden")
    @ApiResponse(responseCode = "404", description = "User nicht gefunden")
    ResponseEntity<UserResponse> getUser(@PathVariable final Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping()
    @ApiResponse(responseCode = "201", description = "User wurde angelegt")
    @ApiResponse(responseCode = "400", description = "Ungültige Eingabe")
    ResponseEntity<UserResponse> createUser(@Valid @RequestBody final CreateUserRequest user){
        UserResponse newUser = userService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.id())
                .toUri();
        return ResponseEntity.created(location).body(newUser);
    }
}
