package com.example.states.exception;

public class StateNotFoundException extends RuntimeException {
    public StateNotFoundException(String codigo) {

        super(String.format("State with id %s not found", codigo));
    }
}
