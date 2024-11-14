package kg.talantova.cinemahub.controller;

import jakarta.validation.Valid;
import kg.talantova.cinemahub.dto.film.FilmCreateRequestDTO;
import kg.talantova.cinemahub.dto.film.FilmResponseDTO;
import kg.talantova.cinemahub.enums.GenreType;
import kg.talantova.cinemahub.exception.CinemaHubException;
import kg.talantova.cinemahub.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FilmResponseDTO> createFilm(@RequestBody @Valid FilmCreateRequestDTO request) throws CinemaHubException {
       return new ResponseEntity<>(filmService.createFilm(request), HttpStatus.CREATED);
    }

    @PutMapping("/{filmId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FilmResponseDTO> updateFilm(@PathVariable("filmId") Long id, @RequestBody @Valid FilmCreateRequestDTO request) {
        return new ResponseEntity<>(filmService.updateFilm(request, id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{filmId}")
    public ResponseEntity<FilmResponseDTO> getFilm(@PathVariable("filmId") Long id) {
        return new ResponseEntity<>(filmService.getFilm(id),  HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FilmResponseDTO>> getAllFilms() {
        return new ResponseEntity<>(filmService.getFilms(),  HttpStatus.OK);
    }

    @DeleteMapping("/{filmId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteFilm(@PathVariable("filmId") Long id) {
        return new ResponseEntity<>(filmService.deleteFilm(id),  HttpStatus.NO_CONTENT);
    }

    @GetMapping("/actor/{actorId}")
    public ResponseEntity<List<FilmResponseDTO>> getAllFilmsByActor(@PathVariable("actorId") Long actorId) {
        return new ResponseEntity<>(filmService.getFilmsByActor(actorId),  HttpStatus.OK);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<FilmResponseDTO>> getAllFilmsByGener(@RequestParam("genre") GenreType genre) {
        return new ResponseEntity<>(filmService.getFilmByGenreType(genre),  HttpStatus.OK);
    }

}