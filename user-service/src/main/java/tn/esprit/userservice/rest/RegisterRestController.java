package tn.esprit.userservice.rest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.userservice.rest.users.dtos.*;
import tn.esprit.userservice.rest.users.dtos.requests.*;
import tn.esprit.userservice.rest.users.services.*;

@RestController
@RequestMapping(value = "/users")
public class RegisterRestController {

    @Autowired
    private UserService userService;

    // register a new user's account: no all the user information are required
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerNewUserAccount(@RequestBody RegisterUserAccountDTO registerUserAccountDTO) {
        return new ResponseEntity<>(new UserDTO(userService.registerUserAccount(registerUserAccountDTO)), null, HttpStatus.CREATED);
    }

}
