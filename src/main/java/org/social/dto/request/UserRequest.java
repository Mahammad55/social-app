package org.social.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "username must not be empty")
    @Size(min = 2, max = 30, message = "required username must be min 2, max 30 character")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "name must not be empty")
    @Size(min = 2, max = 20, message = "required name must be min 2, max 20 character")
    private String name;

    @NotBlank(message = "surname must not be empty")
    @Size(min = 2, max = 20, message = "required surname must be min 2, max 20 character")
    private String surname;

    @NotBlank(message = "email must not be empty")
    @Column(unique = true)
    @Email(message = "email must be in the correct format")
    private String email;

    @NotBlank(message = "password must not be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, and 1 digit, with a minimum length of 8 characters")
    private String password;

    @NotBlank(message = "birthday must not be empty")
    @Column(columnDefinition = "LocalDate")
    private LocalDate birthDate;
}
