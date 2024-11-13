package kg.talantova.cinemahub.entity;

import jakarta.persistence.*;
import kg.talantova.cinemahub.enums.GenreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date releaseDate;
    private Double rating;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<GenreType> genres;
    @ManyToMany
    private List<Actor> actors;
    private String director;
    private String language;
    private String country;
}
