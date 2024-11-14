package kg.talantova.cinemahub.controller;

import jakarta.validation.Valid;
import kg.talantova.cinemahub.dto.ChangePasswordDTO;
import kg.talantova.cinemahub.dto.UserCreateDTO;
import kg.talantova.cinemahub.dto.UserDTO;
import kg.talantova.cinemahub.entity.User;
import kg.talantova.cinemahub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserCreateDTO newUser) {
        return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.OK);
    }

    @PutMapping("/change-password")
    public ResponseEntity<Void> changePassword(@AuthenticationPrincipal User currentUser, @RequestBody @Valid ChangePasswordDTO changePasswordRequest) {
        userService.changePassword(changePasswordRequest, currentUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@AuthenticationPrincipal User currentUser) {
        userService.deleteUser(currentUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDTO> upadteUser(@AuthenticationPrincipal User currentUser,
                                              @RequestBody @Valid UserDTO updatedUser) {
        updatedUser.setId(currentUser.getId());
        return new ResponseEntity<>(userService.updateUser(updatedUser), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<UserDTO> getUserByNickname(@PathVariable("nickname") String nick) {
        return new ResponseEntity<>(userService.getUserByNickname(nick), HttpStatus.OK);
    }

}
