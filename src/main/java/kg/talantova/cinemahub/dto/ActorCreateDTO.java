package kg.talantova.cinemahub.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ActorCreateDTO {
    @NotBlank(message = "First name cannot be blank")
    @Size(max = 50, message = "First name should not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 50, message = "Last name should not exceed 50 characters")
    private String lastName;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be a date in the past")
    private Date birthDate;

    @Size(max = 1000, message = "Biography should not exceed 1000 characters")
    private String biography;

    @NotNull(message = "Films list is required")
    private List<Long> films;
}
