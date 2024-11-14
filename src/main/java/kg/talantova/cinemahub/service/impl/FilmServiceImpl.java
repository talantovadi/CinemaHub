package kg.talantova.cinemahub.service.impl;

import kg.talantova.cinemahub.dto.film.FilmCreateRequestDTO;
import kg.talantova.cinemahub.dto.film.FilmResponseDTO;
import kg.talantova.cinemahub.entity.Actor;
import kg.talantova.cinemahub.entity.Film;
import kg.talantova.cinemahub.enums.GenreType;
import kg.talantova.cinemahub.exception.CinemaHubException;
import kg.talantova.cinemahub.mapper.FilmMapper;
import kg.talantova.cinemahub.repository.ActorRepository;
import kg.talantova.cinemahub.repository.FilmRepository;
import kg.talantova.cinemahub.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository repository;
    private final ActorRepository actorRepository;
    private final FilmMapper filmMapper;

    @Override
    public FilmResponseDTO createFilm(FilmCreateRequestDTO requestDTO) throws CinemaHubException {
        List<Actor> actors = actorRepository.findAllById(requestDTO.getActors());
        if(actors.isEmpty()) {
            throw new CinemaHubException("Ни один актер из списков актеров не был найден! Ошибка создания фильма");
        }
        Film entity = filmMapper.toEntity(requestDTO);
        entity.setActors(actors);
        return filmMapper.toDto(repository.save(entity));
    }

    @Override
    public FilmResponseDTO updateFilm(FilmCreateRequestDTO requestDTO, Long filmId) {
        repository.findById(filmId)
                .orElseThrow(() -> new CinemaHubException("Фильма с таким id не существует!"));
        List<Actor> actors = actorRepository.findAllById(requestDTO.getActors());
        if(actors.isEmpty()) {
            throw new CinemaHubException("Ни один актер из списков актеров не был найден! Ошибка редактирования фильма");
        }
        Film film = filmMapper.toEntity(requestDTO);
        film.setActors(actors);
        film.setId(filmId);
        return filmMapper.toDto(repository.save(film));
    }

    @Override
    public Void deleteFilm(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<FilmResponseDTO> getFilms() {
        return filmMapper.toListDTO(repository.findAll());
    }

    @Override
    public FilmResponseDTO getFilm(Long id) {
       Film film =  repository.findById(id)
                .orElseThrow(() -> new CinemaHubException("Фильма с таким id не существует!"));
       return filmMapper.toDto(film);
    }

    @Override
    public List<FilmResponseDTO> getFilmByGenreType(GenreType type) {
        return filmMapper.toListDTO(repository.findByGenres(type));
    }

    @Override
    public List<FilmResponseDTO> getFilmsByActor(Long actorId) {
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new CinemaHubException("Актера с таким id не существует!"));
        return filmMapper.toListDTO(repository.findByActors(actor));
    }
}
