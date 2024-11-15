package kg.talantova.cinemahub.mapper;

import kg.talantova.cinemahub.dto.actor.ActorCreateDTO;
import kg.talantova.cinemahub.dto.actor.ActorDTO;
import kg.talantova.cinemahub.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    @Mapping(target = "movies", ignore = true)
    ActorDTO toDto(Actor actor);

    @Mapping(target = "movies", ignore = true)
    Actor toEntity(ActorCreateDTO actorCreateDTO);

    List<ActorDTO> toListDTO(List<Actor> actors);
}
