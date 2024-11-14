package kg.talantova.cinemahub.mapper;

import kg.talantova.cinemahub.dto.UserCreateDTO;
import kg.talantova.cinemahub.dto.UserDTO;
import kg.talantova.cinemahub.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreateDTO request);
    User toEntityFromDto(UserDTO userDTO);
    UserDTO toDTO(User user);
    List<UserDTO> toListDTO(List<User> users);
}
