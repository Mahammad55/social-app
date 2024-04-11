package org.social.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String username;

    private String name;

    private String surname;

    private String email;

    @JsonFormat(pattern = "YYYY-MMMM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;
}
