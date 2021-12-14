package com.mongodb.project.common.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(final String message) {
        super(message);
    }
}



//TODO: Forbidden Exception move to Global