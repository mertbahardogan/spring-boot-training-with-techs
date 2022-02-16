package com.mongodb.project.common.exceptions;

public class UsernameNotFoundException extends Exception {

    private final String username;

    public static UsernameNotFoundException createWith(String username) {
        return new UsernameNotFoundException(username);
    }

    private UsernameNotFoundException(String username) {
        this.username = username;
    }

    public String getMessage() {
        return "User not found with username: " + username;
    }
}
