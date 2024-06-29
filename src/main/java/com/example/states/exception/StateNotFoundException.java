package com.example.states.exception;

public class StateNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StateNotFoundException(String codigo) {

        super(String.format("State with id %s not found", codigo));
    }
}
