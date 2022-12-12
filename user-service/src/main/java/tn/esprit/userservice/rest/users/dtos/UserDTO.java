package tn.esprit.userservice.rest.users.dtos;

import lombok.*;
import tn.esprit.userservice.rest.users.entities.*;

import java.io.*;
import java.time.*;
import java.util.*;

@Data
public class UserDTO implements Serializable {

    public UserDTO() {
        // empty constructor
        roles = new ArrayList<>();
        permissions = new ArrayList<>();
    }

    public UserDTO(User user) {
        if (user != null) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.name = user.getName();
            this.surname = user.getSurname();
            this.gender = user.getGender().name();
            this.email = user.getEmail();

            this.birthDate = user.getBirthDate();

            this.enabled = user.isEnabled();

            this.note = user.getNote();

            this.creationDt = user.getCreationDt();
            this.updatedDt = user.getUpdatedDt();
            this.loginDt = user.getLoginDt();

            this.secured = user.isSecured();


            // Because the permissions can be associated to more than one roles i'm creating two String arrays
            // with the distinct keys of roles and permissions.
            roles = new ArrayList<>();
            permissions = new ArrayList<>();

            for (Role role : user.getRoles()) {
                roles.add(role.getRole());
                for (Permission p : role.getPermissions()) {
                    String key = p.getPermission();
                    if ((!permissions.contains(key)) && (p.isEnabled())) {
                        // add the permission only if enabled
                        permissions.add(key);
                    }
                }
            }

        }
    }

    private Long id;
    private String username;
    private String name;
    private String surname;
    private String gender;
    private java.time.LocalDate birthDate;

    private boolean enabled;

    private String note;

    private LocalDateTime creationDt;
    private LocalDateTime updatedDt;
    private LocalDateTime loginDt;

    private boolean secured;

    private String email;


    // permissions and roles list
    private List<String> roles;
    private List<String> permissions;

}
