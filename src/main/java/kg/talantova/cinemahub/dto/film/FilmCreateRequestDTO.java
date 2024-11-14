package kg.talantova.cinemahub.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import kg.talantova.cinemahub.enums.GenreType;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FilmCreateRequestDTO {

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title should not exceed 100 characters")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 500, message = "Description should not exceed 500 characters")
    private String description;

    @JsonProperty("release_date")
    @NotNull(message = "Release date is required")
    private Date releaseDate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Rating cannot be negative")
    @DecimalMax(value = "10.0", inclusive = true, message = "Rating cannot exceed 10.0")
    private Double rating;

    @NotEmpty(message = "At least one genre must be specified")
    private List<GenreType> genres;

    @NotEmpty(message = "At least one actor must be specified")
    private List<Long> actors;

    @NotBlank(message = "Director cannot be blank")
    private String director;

    @NotBlank(message = "Language cannot be blank")
    private String language;

    @NotBlank(message = "Country cannot be blank")
    private String country;
}
