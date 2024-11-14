package kg.talantova.cinemahub.service;

import kg.talantova.cinemahub.dto.user.UserCreateDTO;
import kg.talantova.cinemahub.dto.user.UserDTO;
import kg.talantova.cinemahub.dto.user.UserSignInRequest;
import kg.talantova.cinemahub.dto.user.UserSignInResponse;

public interface AuthService {
    UserDTO signUp(UserCreateDTO request);
    UserSignInResponse signIn(UserSignInRequest request);
}
