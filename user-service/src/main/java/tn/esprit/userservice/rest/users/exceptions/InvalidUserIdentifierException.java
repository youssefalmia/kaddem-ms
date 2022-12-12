package tn.esprit.userservice.rest.users.exceptions;

public class InvalidUserIdentifierException extends RuntimeException {

    public InvalidUserIdentifierException(String message) {
        super(message);
    }

}
