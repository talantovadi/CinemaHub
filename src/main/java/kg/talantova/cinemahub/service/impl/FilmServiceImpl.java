package kg.talantova.cinemahub.service.impl;

import kg.talantova.cinemahub.dto.FilmCreateRequestDTO;
import kg.talantova.cinemahub.dto.FilmResponseDTO;
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
        return null;
    }

    @Override
    public Void deleteFilm(Long id) {
        return null;
    }

    @Override
    public List<FilmResponseDTO> getFilms() {
        return null;
    }

    @Override
    public FilmResponseDTO getFilm(Long id) {
        return null;
    }

    @Override
    public List<FilmResponseDTO> getFilmByGenreType(GenreType type) {
        return null;
    }

    @Override
    public List<FilmResponseDTO> getFilmsByActor(Long actorId) {
        return null;
    }
}
