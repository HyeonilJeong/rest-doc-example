package xyz.nuti.rest.exception;

public class IncorrectedParameterException extends DefaultException {
	private static final long serialVersionUID = 8233668378604782747L;

	public IncorrectedParameterException() {
		super();
	}
	
	public IncorrectedParameterException(String parameter) {
		super((parameter == null ? "null" : parameter) + " is not allowed parameter.");
	}
}
