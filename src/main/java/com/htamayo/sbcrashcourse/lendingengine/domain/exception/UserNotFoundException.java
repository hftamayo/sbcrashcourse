package com.htamayo.sbcrashcourse.lendingengine.domain.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long userId) {
        super("User with id: " + userId + " not found");
    }
}
