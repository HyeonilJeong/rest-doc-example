package xyz.nuti.rest.exception;

public class InvalidParameterException extends DefaultException {
	private static final long serialVersionUID = 8233668378604782747L;

	public InvalidParameterException() {
		super();
	}
	
	public InvalidParameterException(String parameter) {
		super((parameter == null ? "null" : parameter) + " is not allowed parameter.");
	}
}
