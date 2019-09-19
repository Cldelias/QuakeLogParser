package br.com.cldelias.services.exceptions;


public class FileIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FileIntegrityException(String msg) {
		super(msg);
	}
	
	public FileIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
