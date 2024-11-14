package kg.talantova.cinemahub.mapper;

import kg.talantova.cinemahub.dto.actor.ActorDTO;
import kg.talantova.cinemahub.entity.Actor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorDTO toDto(Actor actor);
}
