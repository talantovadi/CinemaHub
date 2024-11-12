package kg.talantova.cinemahub.controller;

import kg.talantova.cinemahub.dto.FilmCreateRequestDTO;
import kg.talantova.cinemahub.dto.FilmCreateResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/films")
public class FilmController {

    @PostMapping
    public ResponseEntity<FilmCreateResponseDTO> createFilm(FilmCreateRequestDTO request) {
        return null;
    }
}
