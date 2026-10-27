package userapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Entity User Class
 *
 * @author MDzan
 */
@Entity
@RequiredArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;
}