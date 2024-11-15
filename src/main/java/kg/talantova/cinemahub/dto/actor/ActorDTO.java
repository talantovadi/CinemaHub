package kg.talantova.cinemahub.dto.actor;

import kg.talantova.cinemahub.dto.film.FilmResponseDTO;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ActorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String biography;
    private List<FilmResponseDTO> movies;
}
