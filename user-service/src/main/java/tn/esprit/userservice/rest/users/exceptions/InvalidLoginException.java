package tn.esprit.userservice.rest.users.exceptions;

public class InvalidLoginException extends RuntimeException {

    public InvalidLoginException(String message) {
        super(message);
    }

}
