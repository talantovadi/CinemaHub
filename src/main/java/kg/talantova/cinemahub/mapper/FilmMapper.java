package kg.talantova.cinemahub.mapper;

import kg.talantova.cinemahub.dto.FilmCreateRequestDTO;
import kg.talantova.cinemahub.dto.FilmResponseDTO;
import kg.talantova.cinemahub.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    @Mapping(target = "actors", ignore = true)
    Film toEntity(FilmCreateRequestDTO requestDTO);
    FilmResponseDTO toDto(Film film);
}
