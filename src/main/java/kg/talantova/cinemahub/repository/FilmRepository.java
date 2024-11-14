package kg.talantova.cinemahub.repository;

import kg.talantova.cinemahub.entity.Actor;
import kg.talantova.cinemahub.entity.Film;
import kg.talantova.cinemahub.enums.GenreType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByGenres(GenreType genreType);
    List<Film> findByActors(Actor actor);
}
