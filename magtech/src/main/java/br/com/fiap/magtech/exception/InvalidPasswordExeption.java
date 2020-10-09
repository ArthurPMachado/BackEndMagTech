package br.com.fiap.magtech.exception;

@SuppressWarnings("serial")
public class InvalidPasswordExeption extends Exception{

	public InvalidPasswordExeption() {
		super();
	}

	public InvalidPasswordExeption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidPasswordExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPasswordExeption(String message) {
		super(message);
	}

	public InvalidPasswordExeption(Throwable cause) {
		super(cause);
	}

}
