package kg.talantova.cinemahub.service;


import kg.talantova.cinemahub.dto.ChangePasswordDTO;
import kg.talantova.cinemahub.dto.UserCreateDTO;
import kg.talantova.cinemahub.dto.UserDTO;
import kg.talantova.cinemahub.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserCreateDTO user);
    Void deleteUser(User user);
    UserDTO updateUser(UserDTO updatedUser);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO getUserByNickname(String nickname);
    Void changePassword(ChangePasswordDTO request, User user);
}
