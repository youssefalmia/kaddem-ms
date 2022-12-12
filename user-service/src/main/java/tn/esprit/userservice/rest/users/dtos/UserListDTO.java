package tn.esprit.userservice.rest.users.dtos;

import lombok.*;

import java.util.*;

/**
 * DTO for the List of users
 */
@Data
public class UserListDTO implements java.io.Serializable {

    private ArrayList<UserDTO> userList;

    public UserListDTO() {
        userList = new ArrayList<>();
    }

}
