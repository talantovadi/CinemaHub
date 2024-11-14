package kg.talantova.cinemahub.service.impl;

import kg.talantova.cinemahub.dto.actor.ActorCreateDTO;
import kg.talantova.cinemahub.dto.actor.ActorDTO;
import kg.talantova.cinemahub.entity.Actor;
import kg.talantova.cinemahub.entity.Film;
import kg.talantova.cinemahub.exception.CinemaHubException;
import kg.talantova.cinemahub.mapper.ActorMapper;
import kg.talantova.cinemahub.repository.ActorRepository;
import kg.talantova.cinemahub.repository.FilmRepository;
import kg.talantova.cinemahub.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    private final FilmRepository filmRepository;

    @Override
    public ActorDTO createActor(ActorCreateDTO actorRequest) {
        List<Film> actorsFilms = filmRepository.findAllById(actorRequest.getMovies());
        if(actorsFilms.isEmpty()) {
            throw new CinemaHubException("Ни один фильм из списка фильмов не был найден! Ошибка создания актера");
        }
        Actor actor = actorMapper.toEntity(actorRequest);
        actor.setMovies(actorsFilms);
        return actorMapper.toDto(actorRepository.save(actor));
    }

    @Override
    public ActorDTO updateActor(ActorCreateDTO actorRequest, Long actorId) {
        List<Film> actorsFilms = filmRepository.findAllById(actorRequest.getMovies());
        if(actorsFilms.isEmpty()) {
            throw new CinemaHubException("Ни один фильм из списка фильмов не был найден! Ошибка редактирования актера");
        }
        isExist(actorId);
        Actor actor = actorMapper.toEntity(actorRequest);
        actor.setMovies(actorsFilms);
        actor.setId(actorId);
        return actorMapper.toDto(actorRepository.save(actor));
    }

    @Override
    public List<ActorDTO> getAllActors() {
       return actorMapper.toListDTO(actorRepository.findAll());
    }

    @Override
    public ActorDTO getActorById(Long id) {
        Actor actor = isExist(id);
        return actorMapper.toDto(actor);
    }

    @Override
    public List<ActorDTO> getActorsByName(String firstName, String lastName) {
        return actorMapper.toListDTO(actorRepository.findByFirstNameOrLastName(firstName, lastName));
    }

    @Override
    public List<ActorDTO> getActorsByFilm(Long filmId) {
        return actorMapper.toListDTO(actorRepository.findByMovies_Id(filmId));
    }

    @Override
    public Void deleteActorById(Long id) {
        isExist(id);
        actorRepository.deleteById(id);
        return null;
    }

    private Actor isExist(Long id) {
         return actorRepository.findById(id)
                .orElseThrow(() -> new CinemaHubException("Актера с таким id не существует!"));
    }
}
