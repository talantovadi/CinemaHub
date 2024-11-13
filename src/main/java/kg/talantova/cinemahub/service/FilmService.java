package kg.talantova.cinemahub.service;

import kg.talantova.cinemahub.dto.FilmCreateRequestDTO;
import kg.talantova.cinemahub.dto.FilmResponseDTO;
import kg.talantova.cinemahub.entity.Actor;
import kg.talantova.cinemahub.enums.GenreType;
import kg.talantova.cinemahub.exception.CinemaHubException;

import java.util.List;

public interface FilmService {
    FilmResponseDTO createFilm(FilmCreateRequestDTO requestDTO) throws CinemaHubException;
    FilmResponseDTO updateFilm(FilmCreateRequestDTO requestDTO, Long filmId);
    Void deleteFilm(Long id);
    List<FilmResponseDTO> getFilms();
    FilmResponseDTO getFilm(Long id);
    List<FilmResponseDTO> getFilmByGenreType(GenreType type);
    List<FilmResponseDTO> getFilmsByActor(Long actorId);

}
