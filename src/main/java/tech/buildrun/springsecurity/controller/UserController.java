package tech.buildrun.springsecurity.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.springsecurity.controller.dto.CreateUserDTO;
import tech.buildrun.springsecurity.entity.User;
import tech.buildrun.springsecurity.service.UserService;

import java.util.List;

@RestController
@Transactional
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Void> newUser(@RequestBody CreateUserDTO dto) {
        userService.createUser(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_admin')")
    public ResponseEntity<List<User>> listAllUsers(){

       var users = userService.listUsers();
        return ResponseEntity.ok(users);
    }
}
