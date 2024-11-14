package kg.talantova.cinemahub.dto.film;

import kg.talantova.cinemahub.dto.actor.ActorDTO;
import kg.talantova.cinemahub.enums.GenreType;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FilmResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Date releaseDate;
    private Double rating;
    private List<GenreType> genres;
    private List<ActorDTO> actors;
    private String director;
    private String language;
    private String country;
}
