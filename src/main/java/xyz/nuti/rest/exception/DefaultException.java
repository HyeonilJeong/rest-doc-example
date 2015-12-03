package xyz.nuti.rest.exception;

public class DefaultException extends Exception {
	private static final long serialVersionUID = 1062331273136094795L;

	private String code;
	private String message;
	
	public DefaultException() {
		this("", "");
	}
	
	public DefaultException(String message) {
		this("", message);
	}
	
	public DefaultException(String code, String message) {
		this(message, new Throwable(message));
		this.code = code;
	}

	public DefaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}

	public DefaultException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public DefaultException(Throwable cause) {
		super(cause);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
