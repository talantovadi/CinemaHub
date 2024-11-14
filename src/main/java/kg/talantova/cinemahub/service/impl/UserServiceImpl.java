package kg.talantova.cinemahub.service.impl;

import jakarta.transaction.Transactional;
import kg.talantova.cinemahub.dto.ChangePasswordDTO;
import kg.talantova.cinemahub.dto.UserCreateDTO;
import kg.talantova.cinemahub.dto.UserDTO;
import kg.talantova.cinemahub.entity.User;
import kg.talantova.cinemahub.exception.CinemaHubException;
import kg.talantova.cinemahub.mapper.UserMapper;
import kg.talantova.cinemahub.repository.UserRepository;
import kg.talantova.cinemahub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserCreateDTO user) {
        if(!user.getPassword().equals(user.getRepeatPassword())) {
            throw new CinemaHubException("Пароли не совпадают !");
        }
        if(userRepository.findByNickname(user.getNickname()).isPresent()) {
            throw new CinemaHubException("Пользователь с таким никнеймом уже существует!");
        }
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new CinemaHubException("Пользователь с такой эл. почтой уже существует !");
        }

        return userMapper.toDTO(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public Void deleteUser(User user) {
        userRepository.delete(user);
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO updatedUser) {
       return userMapper.toDTO(userRepository.save(userMapper.toEntityFromDto(updatedUser)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toListDTO(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CinemaHubException("Пользователь с таким id не найден!"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname)
                .orElseThrow(() -> new CinemaHubException("Пользователь с таким никнеймом не найден!"));
        return userMapper.toDTO(user);
    }

    @Override
    public Void changePassword(ChangePasswordDTO request, User currentUser) {
       if(!currentUser.getPassword().equals(request.getOldPassword())) {
           throw new CinemaHubException("Неверный старый пароль!");
       }
       currentUser.setPassword(request.getNewPassword());
       userRepository.save(currentUser);
       return null;
    }
}
