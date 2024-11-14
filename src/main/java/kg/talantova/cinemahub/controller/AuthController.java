package kg.talantova.cinemahub.controller;

import jakarta.validation.Valid;
import kg.talantova.cinemahub.dto.user.UserCreateDTO;
import kg.talantova.cinemahub.dto.user.UserDTO;
import kg.talantova.cinemahub.dto.user.UserSignInRequest;
import kg.talantova.cinemahub.dto.user.UserSignInResponse;
import kg.talantova.cinemahub.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<UserDTO> signUp(@Valid @RequestBody UserCreateDTO user) {
        return new ResponseEntity<>(authService.signUp(user), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserSignInResponse> authenticate(@Valid @RequestBody UserSignInRequest user) {
        return new ResponseEntity<>(authService.signIn(user), HttpStatus.OK);
    }
}
