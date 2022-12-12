package tn.esprit.userservice.rest.users.entities;


import tn.esprit.userservice.rest.users.exceptions.*;

public enum Gender {

    MALE(1), FEMALE(2);

    private int gender;

    Gender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

    public static Gender getValidGender(String genderName) {
        Gender gender;
        try {
            gender = Gender.valueOf(genderName);
        } catch(IllegalArgumentException ex) {
            throw new InvalidGenderException(String.format("Invalid gender string %s. Are supported only: MALE or FEMALE strings", genderName));
        }
        return gender;
    }

}
