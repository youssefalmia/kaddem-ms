package tn.esprit.userservice.rest.users.dtos.requests;

import lombok.*;

import java.io.*;

/**
 * Create or modify user data
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrUpdateUserDTO implements Serializable {

    private String username;
    private String password;

    private String name;
    private String surname;
    private String gender;
    private java.time.LocalDate birthDate;

    private boolean enabled;
    private boolean secured;

    private String note;

    // contact information
    private String email;
    private String phone;
    private String skype;
    private String facebook;
    private String linkedin;
    private String website;
    private String contactNote;

    // address information
    private String address;
    private String address2;
    private String city;
    private String country;
    private String zipCode;

}
