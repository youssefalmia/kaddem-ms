package tn.esprit.userservice.rest;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.userservice.rest.users.dtos.*;
import tn.esprit.userservice.rest.users.dtos.requests.*;
import tn.esprit.userservice.rest.users.entities.*;
import tn.esprit.userservice.rest.users.services.*;

@RestController
@RequestMapping(value = "/login")
@Slf4j
public class LoginRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        User user = userService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        return ResponseEntity.ok(new UserDTO(user));
    }

}
