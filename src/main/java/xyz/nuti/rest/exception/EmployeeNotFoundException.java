package xyz.nuti.rest.exception;

public class EmployeeNotFoundException extends DefaultException {
	private static final long serialVersionUID = 586236237059871800L;

	public EmployeeNotFoundException() {
		super("Cannot find employee");
	}
	
	public EmployeeNotFoundException(String name) {
		super("Cannot find the employee who name is " + name + ".");
	}
}
