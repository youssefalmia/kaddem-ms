package tn.esprit.userservice.rest.users.exceptions;

public class InvalidUsernameException extends RuntimeException {

    public InvalidUsernameException(String message) {
        super(message);
    }

}
