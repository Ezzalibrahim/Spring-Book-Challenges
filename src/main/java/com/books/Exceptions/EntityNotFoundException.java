package com.books.Exceptions;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message) {
        super(message);
        System.out.println("Entity Not found Exception  ");
    }
}
