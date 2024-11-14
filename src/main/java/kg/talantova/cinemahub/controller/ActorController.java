package kg.talantova.cinemahub.controller;

import jakarta.validation.Valid;
import kg.talantova.cinemahub.dto.actor.ActorCreateDTO;
import kg.talantova.cinemahub.dto.actor.ActorDTO;
import kg.talantova.cinemahub.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ActorDTO> createActor(@RequestBody @Valid ActorCreateDTO actorRequest) {
        return new ResponseEntity<>(actorService.createActor(actorRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActorDTO>> getAllActors() {
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(actorService.getActorById(id), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<ActorDTO>> getActorsByName(@RequestParam("firstname") String firstName,
                                          @RequestParam("lastName") String lastName) {
        return new ResponseEntity<>(actorService.getActorsByName(firstName, lastName), HttpStatus.OK);
    }

    @GetMapping("/find/byFilm/{filmId}")
    public ResponseEntity<List<ActorDTO>> getActorsByFilm(@PathVariable("filmId") Long filmId) {
        return new ResponseEntity<>(actorService.getActorsByFilm(filmId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteActorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(actorService.deleteActorById(id), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ActorDTO> updateActor(@PathVariable("id") Long id,
                                                @RequestBody @Valid ActorCreateDTO actorRequest
    ) {
        return new ResponseEntity<>(actorService.updateActor(actorRequest, id), HttpStatus.OK);
    }

}
