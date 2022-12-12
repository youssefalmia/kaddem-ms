package tn.esprit.userservice.rest.users.dtos.requests;

import lombok.*;

import java.io.*;

/**
 * Support the creation of a new user account with a minimum set of required data
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserAccountDTO implements Serializable {

    private String username;
    private String password;

    private String name;
    private String surname;
    private String email;
    private String gender;

}
