package tn.esprit.userservice.rest.users.exceptions;

import lombok.*;

@Data
public class ErrorDetails implements java.io.Serializable {

    private final String message;

    private final long timestamp;

    public ErrorDetails(final String message) {
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

}
