package kg.talantova.cinemahub.service.impl;

import kg.talantova.cinemahub.dto.actor.ActorCreateDTO;
import kg.talantova.cinemahub.dto.actor.ActorDTO;
import kg.talantova.cinemahub.service.ActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    @Override
    public ActorDTO createActor(ActorCreateDTO actorRequest) {
        return null;
    }

    @Override
    public List<ActorDTO> getAllActors() {
        return null;
    }

    @Override
    public ActorDTO getActorById(Long id) {
        return null;
    }

    @Override
    public List<ActorDTO> getActorsByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<ActorDTO> getActorsByFilm(Long filmId) {
        return null;
    }

    @Override
    public Void deleteActorById(Long id) {
        return null;
    }

    @Override
    public ActorDTO updateActor(ActorCreateDTO actorRequest) {
        return null;
    }
}
