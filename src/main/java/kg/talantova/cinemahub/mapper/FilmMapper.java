package kg.talantova.cinemahub.mapper;

import kg.talantova.cinemahub.dto.film.FilmCreateRequestDTO;
import kg.talantova.cinemahub.dto.film.FilmResponseDTO;
import kg.talantova.cinemahub.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    @Mapping(target = "actors", ignore = true)
    Film toEntity(FilmCreateRequestDTO requestDTO);

    FilmResponseDTO toDto(Film film);

    List<FilmResponseDTO> toListDTO(List<Film> films);
}
