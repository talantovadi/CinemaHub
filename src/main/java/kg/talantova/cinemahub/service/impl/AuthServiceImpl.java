package kg.talantova.cinemahub.service.impl;

import kg.talantova.cinemahub.dto.user.UserCreateDTO;
import kg.talantova.cinemahub.dto.user.UserDTO;
import kg.talantova.cinemahub.dto.user.UserSignInRequest;
import kg.talantova.cinemahub.dto.user.UserSignInResponse;
import kg.talantova.cinemahub.entity.User;
import kg.talantova.cinemahub.enums.Role;
import kg.talantova.cinemahub.exception.CinemaHubException;
import kg.talantova.cinemahub.mapper.UserMapper;
import kg.talantova.cinemahub.repository.UserRepository;
import kg.talantova.cinemahub.service.AuthService;
import kg.talantova.cinemahub.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserDTO signUp(UserCreateDTO request) {
        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new CinemaHubException("Пароли не совпадают");
        }

        if(userRepository.findByNickname(request.getNickname()).isPresent()) {
            throw new CinemaHubException("Пользователь с таким никнеймом уже существует!");
        }
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CinemaHubException("Пользователь с такой эл. почтой уже существует !");
        }

        User userEntity = userMapper.toEntity(request);
        userEntity.setRole(Role.ROLE_USER);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userMapper.toDTO(userRepository.save(userEntity));
    }

    @Override
    public UserSignInResponse signIn(UserSignInRequest request) {
        User userEntity = userRepository.findByNickname(request.getNickname())
                .orElseThrow(() -> new CinemaHubException("Пользователь с таким никнеймом не найден"));

        if (!passwordEncoder.matches(request.getPassword(), userEntity.getPassword())) {
            throw new CinemaHubException("Вы ввели неверный пароль");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getNickname(),
                        request.getPassword()
                )
        );

        String jwtToken = jwtService.generateToken(userEntity);
        return new UserSignInResponse(jwtToken);
    }

}
