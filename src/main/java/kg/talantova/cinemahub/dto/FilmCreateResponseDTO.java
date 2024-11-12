package kg.talantova.cinemahub.dto;

import kg.talantova.cinemahub.entity.Actor;
import kg.talantova.cinemahub.entity.Genre;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FilmCreateResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Date releaseDate;
    private Double rating;
    private List<Genre> genres;
    private List<Actor> actors;
    private String director;
    private String language;
    private String country;
}
