package tn.esprit.userservice.rest;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.userservice.rest.users.exceptions.*;

/** Handles the exceptions globally in this microservice */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidEmailException.class, InvalidGenderException.class, InvalidUserDataException.class,
            InvalidUserIdentifierException.class, InvalidRoleIdentifierException.class, InvalidUsernameException.class,
            InvalidLoginException.class, InvalidPermissionDataException.class, InvalidRoleDataException.class,
            RoleInUseException.class, PermissionInUseException.class})
    public ResponseEntity<ErrorDetails> handleAsBadRequest(RuntimeException ex) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RoleNotFoundException.class, UserNotFoundException.class, UserIsSecuredException.class,
            PermissionNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleAsNotFound(RuntimeException ex) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
