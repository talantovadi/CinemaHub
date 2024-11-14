package kg.talantova.cinemahub.service;

import kg.talantova.cinemahub.dto.actor.ActorCreateDTO;
import kg.talantova.cinemahub.dto.actor.ActorDTO;

import java.util.List;

public interface ActorService {
    ActorDTO createActor(ActorCreateDTO actorRequest);
    List<ActorDTO> getAllActors();
    ActorDTO getActorById(Long id);
    List<ActorDTO> getActorsByName(String firstName, String lastName);
    List<ActorDTO> getActorsByFilm(Long filmId);
    Void deleteActorById(Long id);
    ActorDTO updateActor(ActorCreateDTO actorRequest);

}
