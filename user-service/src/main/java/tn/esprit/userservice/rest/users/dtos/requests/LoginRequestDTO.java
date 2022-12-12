package tn.esprit.userservice.rest.users.dtos.requests;

import lombok.*;

import java.io.*;

/**
 * User account login
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO implements Serializable {

    private String username;
    private String password;

}
