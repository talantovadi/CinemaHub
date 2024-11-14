package kg.talantova.cinemahub.repository;

import kg.talantova.cinemahub.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findByFirstNameOrLastName(String firstname, String lastname);
    List<Actor> findByMovies_Id(Long filmId);
}
