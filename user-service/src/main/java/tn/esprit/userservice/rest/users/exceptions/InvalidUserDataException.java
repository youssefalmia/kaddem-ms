package tn.esprit.userservice.rest.users.exceptions;

public class InvalidUserDataException extends RuntimeException {

    public InvalidUserDataException(String message) {
        super(message);
    }

}
